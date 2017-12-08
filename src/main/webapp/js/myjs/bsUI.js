/**
 * 基于bootstrap的UI组件
 */
$(function() {
		/**
		 * 
		 * @param beans:实体集合
		 * @param caption 表格标题
		 * @param columns 要显示的列
		 * [
		 * 	{	
		 * 		name:父列名称,
		 * 		column:实体的名称,
		 * 		contain:true或false，子元素要不要使用列名，如果为true,使用父列名,子元素所有的值都使用父列名，false,使用子列名
		 * 		headValign:垂直对齐, 默认垂直居中 top,middle,bottom
		 * 		headHalign:水平对齐,	默认左边对齐 left,center,right
		 * 		valign:垂直对齐, 默认垂直居中 top,middle,bottom
		 * 		halign:水平对齐,	默认左边对齐 left,center,right
		 * 		ellipsis:文字过长要不要省略，默认不省略
		 * 		children:{
		 * 			name:子列名称,
		 * 			column:实体的名称,
		 * 			children:null
		 * 			……
		 * 		},
		 * 		buttons:{"删除":function(bean){},"编辑":function(bean){}}
		 * 	}
		 * ]
		 */
		/**
		 * 如：
		 * $("#con").appendTable({
			beans:[
			       {id:1,name:"张三张三",age:18,
			    	   address:[{id:12,province:"广东省",city:"广州"}],
			    	   teachers:[{id:15,name:"王老师"},{id:17,name:"马老师"}]
			       },
			       {id:1,name:"张三",age:18,
			    	   address:[{id:12,province:"广东省",city:"广州"}],
			    	   teachers:[{id:15,name:"王老师"}]
			       },
			       {id:3,name:"五一",age:18,address:null,teachers:null}
			       ],
			caption:"学生表",
			columns:[
			         {name:"编号",column:"id",halign:"center",children:null},
			         {name:"姓名",column:"name",halign:"left",children:null},
			         {name:"年龄",column:"age",halign:"center",children:null},
			         {name:"地址",column:"address",halign:"center",contain:false,children:[{name:"省份",halign:"center",column:"province"},{name:"城市",halign:"center",column:"city"}]},
			         {name:"老师",column:"teachers",halign:"center",contain:true,children:[{name:"编号",column:"id"},{name:"姓名",column:"name"}]},
			         {name:"操作",halign:"center"},
						buttons:{
							"修改":function(item){
				        		 alert("修改："+item.name);
				        	 },
							"删除":function(item){
				        		 alert("修改："+item.name);
				        	 }
				 		}
			         ],
		});
		 */
		$.fn.appendTable = function (options){
			//内部函数定义
			/**
			 * 生成表格标题栏
			 */
			function getTh(head,columns){
				for(var i = 0;i<columns.length;i++){
					var cfg = columns[i];//获得列配置信息
					var children = cfg.children;
					if(children && !cfg.contain){//存在子元素并且不使用父列名
						//使用递归生成
						getTh(head,children);
					}else{//不存在
						//使用提供的名称，否则使用列名
						var name = cfg.name?cfg.name:cfg.column;
						head.append("<th style='"+getHeadAlign(cfg)+"'>"+name+"</th>");
					}
				}
			}
			/**
			 * 根据配置列配置信息获得数据对齐样式
			 * @param cfg
			 * @returns {String}
			 */
			function getAlign(cfg){
				var cls = "";
				if(cfg.valign == "top"){
					cls += "vertical-align: top;";
				}else if(cfg.valign == "bottom"){
					cls += "vertical-align: top;";
				}else{
					cls += "vertical-align: middle;";
				}
				if(cfg.halign == "left"){
					cls += "text-align: left;";
				}else if(cfg.halign == "right"){
					cls += "text-align: right;";
				}else{
					cls += "text-align: center;";
				}
				if(cfg.ellipsis){
					cls += "white-space:nowrap;overflow:hidden;text-overflow:ellipsis;";
				}
				return cls;
			}
			/**
			 * 根据配置列配置信息获得标题对齐样式
			 * @param cfg
			 * @returns {String}
			 */
			function getHeadAlign(cfg){
				var cls = "";
				if(cfg.headValign == "top"){
					cls += "vertical-align: top;";
				}else if(cfg.headValign == "bottom"){
					cls += "vertical-align: top;";
				}else{
					cls += "vertical-align: middle;";
				}
				if(cfg.headHalign == "left"){
					cls += "text-align: left;";
				}else if(cfg.headHalign == "right"){
					cls += "text-align: right;";
				}else{
					cls += "text-align: center;";
				}
				return cls;
			}
			/**
			 * 生成表格数据
			 * @param tr
			 * @param bean
			 * @param columns
			 */
			function getTr(tr,bean,columns){
				for(var i = 0;i<columns.length;i++){
					var cfg = columns[i];//获得列配置信息
					var children = cfg.children;
					if(children && !children.push) throw "children必须是数组对象！！！";
					if(children && !cfg.contain){//存在子元素并且不使用父列名
						//使用递归生成
						getTr(tr,bean[cfg.column],children);
					}else{//不存在
						//如果没有column列，说明是操作列
						if(cfg.column){//数据列
							var val = bean != null && bean[cfg.column] != null?bean[cfg.column]:"";//获得该属性对应的值
							tr.append("<td style='"+getAlign(cfg)+"'>"+val+"</td>");
						}else{//操作列
							getBtns(tr,bean,cfg);
						}
					}
				}
			}
			/**
			 * 生成按钮
			 * @param tr
			 * @param bean
			 * @param buttons
			 */
			function getBtns(tr,bean,cfg){
				//添加按钮列
				var cls = "";
				if(cfg.column == null){//没有column属性代表中一个操作列
					cls = getAlign(cfg);//获得配置的样式
					var ops = $("<td style='"+cls+"'></td>");
					//为按钮绑定事件
					/*for(var j = 0;j<buttons.length;j++){
						var btnCfg = buttons[j];
						var btn = $("<button type='button' name='"+btnCfg.name+"' class='btn btn-primary' style='margin-left:5px;' >"+btnCfg.name+"</button>");
						var fun = btnCfg.handdle;
						btn.click(function(){
							fun(bean);
						});
						ops.append(btn);
					}*/
					//使用上面的方式会出错，定义成函数就不会出错了
					if(cfg.buttons == null) throw "["+cfg.name+"]列没有配置对应的按钮信息(buttons)";
					for(var btnName in cfg.buttons){
						var fun = cfg.buttons[btnName];
						var btn = $("<button type='button' name='"+btnName+"' class='btn btn-primary' style='margin:2px;' >"+btnName+"</button>");
						bindFun(btn,"click",fun,bean)
						ops.append(btn);
					}
					tr.append(ops);
				}
			}
			/*function getBtns(tr,bean,cfg){
				//添加按钮列
				var cls = "";
				if(cfg.column == null){//没有column属性代表中一个操作列
					cls = getAlign(cfg);//获得配置的样式
					var ops = $("<td style='"+cls+"'></td>");
					var menu = $("<div class='dropdown'><button type='button' class='btn dropdown-toggle' id='dropdownMenu"+bean.id+"' data-toggle='dropdown'>操作<span class='caret'></span></button><ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu"+bean.id+"'></ul></div>");
					//为按钮绑定事件
					if(cfg.buttons == null) throw "["+cfg.name+"]列没有配置对应的按钮信息(buttons)";
					for(var btnName in cfg.buttons){
						var fun = cfg.buttons[btnName];
						var li = $("<li role='presentation'><a role='menuitem' tabindex='-1' href='#'>"+btnName+"</a></li>");
						bindFun(li,"click",fun,bean)
						menu.find("ul").append(li);
					}
					ops.append(menu);
					tr.append(ops);
				}
			}*/
			/**
			 * 生成表格
			 */
			function getTable(tbody,beans,columns){
				//生成表格
				for(var i = 0;i<beans.length;i++){
					//获得一个实体
					var bean = beans[i];
					//每一个实体就是一行
					var tr = $("<tr data-id='"+bean.id+"' ></tr>");
					//生成一行数据
					getTr(tr,bean,columns);
					tbody.append(tr);
				}
			}
			/**
			 * 生成表头
			 * @param columns
			 * @param buttons
			 * @returns
			 */
			function getThead(thead,columns){
				//生成表头
				var head = $("<tr></tr>");
				getTh(head,columns);
				thead.append(head);
			}
			//参数处理
			var container = $(this);
			var caption = options.caption;
			var beans = options.beans;
			var columns = options.columns;
			if(columns == null) throw "columns不能为空！！！";
			
			//生成表格标题
			var cap = caption?"<caption class='text-center' ><h3>"+caption+"</h3></caption>":"";
			//创建表格对象
			var table = $("<table class='table table-hover table-bordered table-striped' style='word-break:break-all; word-wrap:break-all;table-layout:fixed;'>"+cap+"<thead></thead><tbody></tbody></table>");
			//生成表头
			var thead = table.find("thead");
			getThead(thead,columns);
			//如果数据集合不为空
			if(beans != null && beans.length != 0){
				//生成数据
				var tbody = table.find("tbody");
				getTable(tbody,beans,columns);
			}else{
				table.find("tbody").append("<tr><td colspan='"+thead.find("th").size()+"' class='text-center'>没有数据</td></tr>");
			}
			//设置表格td的样式,如果文字太多就显示省略号
			/*table.find("td").css({
				"white-space":"nowrap",
				"overflow":"hidden",
				"text-overflow":"ellipsis"
			});*/
			//添加表格
			container.append(table);
		}


		/**
		 * 生成分页
		 * pageIndex:当前页数
		 * pages:总页数
		 * len:邻距
		 * action:function (pageIndex){}
		 * @param options
		 */
		/**
		 * 如：
		 * $("#con").appendPagination({
			pageIndex:12,
			pages:20,
			len:5,
			action:function(index){
				alert(index);
			}
		});
		 */
		$.fn.appendPagination = function(options){
			//内部函数
			/**
			 * 为分页的一个项绑定函数
			 * @param label
			 * @param fun
			 * @param params
			 * @returns {String}
			 */
			function getPaginationAction(label,fun,params){
				var obj = $("<li><a>"+label+"</a></li>");
				bindFunForTag(obj, "click", fun, params);
				return obj;
			}
			//参数获取
			var container = $(this);
			var pageIndex = options.pageIndex;
			if(pageIndex == null) throw "pageIndex不能为空！！！";
			var pages = options.pages;
			if(pages == null) throw "pages不能为空！！！";
			var action = options.action;
			if(action == null) throw "action不能为空！！！";
			var len = options.len;
			if(len == null) len = 5;//默认为5
			//生成分页对象
			var pagination = $("<div class='text-center'><ul class='pagination'></ul></div>");
			var ul = pagination.find(".pagination");
			//更新分页数据
			if(pages <= 1) return;//没有查询到数据或只有一页时，不需要分页
			//上一页
			if(pageIndex>1){
				ul.append(getPaginationAction("&laquo;", action, pageIndex-1));
			}else{
				ul.append("<li class='disabled'><a >&laquo;</a></li>");//上一页
			}
			//当前页前面页码
			if(pageIndex<len){
				for(var i = 1;i<pageIndex;i++){
					ul.append(getPaginationAction(i, action, i));
				}
			}else{
				for(var i = pageIndex-len;i<pageIndex;i++){
					ul.append(getPaginationAction(i, action, i));
				}
			}
			//当前页码
			ul.append("<li class='active'><a>"+pageIndex+"</a></li>");
			//当前页后面页码
			if(pageIndex<pages-len){
				for(var i = pageIndex+1;i<pageIndex+len;i++){
					ul.append(getPaginationAction(i, action, i));
				}
			}else{
				for(var i = pageIndex+1;i<=pages;i++){
					ul.append(getPaginationAction(i, action, i));
				}
			}
			//下一页
			if(pageIndex<pages){
				ul.append(getPaginationAction("&raquo;", action, pageIndex+1));
			}else{
				ul.append("<li class='disabled'><a>&raquo;</a></li>");
			}
			//添加分页
			container.append(pagination);
			//被替换掉以后再次替换就无效了
			//container.replaceWith(pagination);
		}
		$.dialog = new function (){
			this.alert = function(text,title,handle){
				var dialog = new Dialog({
					title:title?title:"系统提示",
					content:text?text:"",
					buttons:{
					   	 "确定":function(dialog){
							 dialog.close();
							 //如果有处理函数就执行
							 if(handle) handle();
						 }
					}
				});
				dialog.show();
			}
			this.confirm = function(text,title,handle){
				var dialog = new Dialog({
					title:title?title:"系统提示",
					content:text?text:"",
						buttons:{
							"确定":function(dialog){
								dialog.close();
								handle(true);
							},
							"取消":function(dialog){
								dialog.close();
								handle(false);
							}
						}
				});
				dialog.show();
			}
		}
});

/**
 * 为一个标签绑定一个事件
 * @param tag
 * @param type
 * @param fun
 * @param params
 * @returns
 */
function bindFunForTag(tag,type,fun,params){
	bindFun(tag, type, fun, params);
	return tag;
}

/**
 * @param ops
 * @param btnCfg
 * @param bean
 */
function bindFun(obj,type,fun,params){
	obj.bind(type,function(){
		fun(params);
	});
	return obj;
}

/**
 * 
 * @param options
 * 		title:标题
 * 		//type:标题栏类型（default,primary,info,success,warning,danger）
 * 		content:内容
 * 		width:宽度
 * 		height:高度
 * 		show:显示的样式
 * 		close:关闭的样式
 * 		//model:是否模式化显示
 * 		left:左边的距离(默认为居中)
 * 		top:上边的距离(默认为居中)
 * 		buttons:操作
 * 			{
 * 				"删除":function(dialog){}
 * 			}
 * @returns {Dialog}
 */
function Dialog(options){
	this.options = options;
	this.result = undefined;
	this.show = function(){
		this.dialog.show("fold");
	}
	this.close = function(){
		this.dialog.hide("fold");
	}
	/**
	 * 窗体的本身
	 */
	this.dialog = (function(dlg){
		var options = dlg.options;
		var dialog = $("<div class='panel panel-primary' style='position: absolute;'></div>");
		//标题栏
		var title = options.title?options.title:"";
		var header = $("<div class='panel-heading'><h3 class='panel-title'><strong>"+title+"</strong></h3></div>");
		//主题
		var content = options.content?options.content:"";
		var body = $("<div class='panel-body panel-default'><p style='font-size: 18px;text-indent: 2em;padding: 1em;'>"+content+"</p></div>");
		//底部
		var buttons = options.buttons;
		var footer = $("<div class='panel-footer' style='overflow: hidden;'></div>");
		for(var name in buttons){
			footer.prepend(bindFun($("<button type='button' class='btn btn-default' style='float: right;margin-left:5px;'>"+name+"</button>"), "click", buttons[name], dlg));
		}
		//将组件加入到对话框
		dialog.append(header);
		dialog.append(body);
		dialog.append(footer);
		//对话框
		dialog.hide();
		//设置可拖拽
		dialog.draggable({ 
			handle: ".panel-heading",
			containment: "document"
		});
		//加入网页
		$("body").append(dialog);
		//设置样式
		var w_width = $(window).width();
		var W_height = $(window).height();
		var style = {};

		//窗体宽度
		var width = parseInt(options.width);
		if(width){
			style["width"] = width+"px";
		}
		//窗体高度
		var height = parseInt(options.height);
		if(height){
			style["height"] = height+"px";
		}
		//左边距
		var left = parseInt(options.left);
		if(left){
			style["left"] = left+"px";
		}else{
			var width = dialog.width();
			top = (w_width-width)/2;
			style["left"] = top+"px";
		}
		//上边距
		var top = parseInt(options.top);
		if(top){
			style["top"] = top+"px";
		}else{
			var height = dialog.height();
			top = (W_height-height)/2;
			style["top"] = top+"px";
		}
		dialog.css(style);
		
		return dialog;
	})(this);

}
