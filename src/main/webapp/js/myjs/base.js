$(function() {
		//开启提示工具
		$("[data-toggle='tooltip']").tooltip();
		//为字符串增加【包含】功能
		String.prototype.contains = function(char){
			return this.indexOf(char) != -1;
		}
		//为数组增加【包含】功能
		Array.prototype.contains = function(item){
			for(var i in this){
				if(this[i] == item){
					return true;
				}
			}
			return false;
		}
		
		
		//使用json数据进行post提交
		$.postJson = function(url,data,success){
			$.ajax({
				"url":url,
				"type":"POST",
				"contentType":"application/json",
				"data":data,
				"dataType":"json",
				"success":success
			});
		}
		
		//将form表单转换成json数据
		/*
		 * 如：name.firstName=joe&name.lastName=james&age=18
		 * 生成如下：
		 *  {name.firstName:joe,name.lastName=james,age:18}
		 * 
		 */
		/*$.fn.serializeObject = function(){
			var o = {};
			var a = this.serializeArray();
			$.each(a, function() {
			    if (o[this.name]) {//多个相同name时，生成一个数组保存
			        if (!o[this.name].push) {
			            o[this.name] = [o[this.name]];
			        }
			        o[this.name].push(this.value || '');
			    } else {//一个name时生成一个属性值
			        o[this.name] = this.value || '';
			    }
			});
			return JSON.stringify(o);
		};*/
		
		/*
		 * 将form表单转换成json数据，如果值中包含.时，就应该生成对应的属性对象
		 *  如：name.firstName=joe&name.lastName=james&age=18
		 *  生成如下：
		 *  {name:{firstName:joe,lastName=james},age:18}
		 *  
		 *  filterProperties：过滤属性，该数组中包含的属性不会序列化
		 *  filterValues：过滤值，该数组中包含的值不会序列化
		 *  
		 *  
		 */
		$.fn.serializeObject = function(filterProperties,filterValues){
			/**
			 * 解析每一个项的函数
			 * obj:将表单对象的值整理存放到obj对象中，如：{user:{computer:{cpu:{speed:"1.5GHZ"}}}}
			 * name:表单域名称，如：user.computer.cpu.name
			 * val:表单域的值，如：i5
			 * 
			 * 
			 * 生成的结果是{user:{computer:{cpu:{speed:"1.5GHZ",name:"i5"}}}}
			 *                                               --------
			 */
			function parseItem(obj,name,val){
				//检测name中是否包含.符号，也就是类似：user.computer.cpu.name
				if(name.contains(".")){
					//获得name的前部分，如：user.computer.cpu.name 获得user
					var itemName = name.substring(0,name.indexOf("."));
					//获得name的后部分，如：user.computer.cpu.name 获得computer.cpu.name
					var otherName = name.substring(name.indexOf(".")+1);
					//检测obj中是否已经包含itemName这样的对象，如：obj={user:{}},说明obj包含user对象
					var result = null;//用于保存处理后的结果
					if(obj[itemName]){
						//如果对象已经存在，就递归解析，并将该对象传递进入
						result = parseItem(obj[itemName],otherName,val);
					}else{
						//如果对象不存在，就递归解析，并将该{}传递进入（不存在，就创建一个空对象）
						result = parseItem({},otherName,val);
					}
					//返回递归后的结果，如果返回的值不为{}就加入到对象
					//如果一个对象返回{}是没有用的，所以将这种情况过滤掉
					if(JSON.stringify(result) != "{}"){
						obj[itemName] = result;
					}
					return obj;
				}
				//过滤属性和过滤值
				if((filterProperties == null || !filterProperties.contains(name)) &&
						(filterValues == null || !filterValues.contains(val))){
					//如果name中不包含.符号,也就是类似：name  -->user.computer.cpu.【name】
					//多个相同name时，生成一个数组保存
					if (obj[name] != null) {
						//如果obj[name]值不是一个数组（只有数组有push方法，如果不没有就为undefined）
				        if (!obj[name].push) {
				        	//创建一个数组存入
				        	obj[name] = [obj[name]];
				        }
				        //直接当成数组使用
				        obj[name].push(val || '');
				    } else {//一个name时生成一个属性值
				    	obj[name] = val || '';
				    }
				}
				//返回结果
				return obj;
			}
			//创建一个空对象
			var obj = {};
			//获得表单全部域数组
			var array = this.serializeArray();
			//循环解析
			$.each(array, function() {
				obj = parseItem(obj,this.name,this.value);
			});
			//返回json对象
			return JSON.stringify(obj);
		};
});