$(function() {
	searchClazzs();
	search();
});
function search(){
	$("#btn_search").click(function(){
		//每一次查询就会跳转到查询结果的第1页
		gotoPage(1);
	});
}
/**
 * 跳转到指定页面
 * @param pageIndex
 */
function gotoPage(pageIndex){
	//如果指定页码就跳转到相应的页面
	if(pageIndex)
		$("input[name=pageIndex]").val(pageIndex);
	//收集数据
	var params = $("#frm_search").serializeObject(); 
	//去数据库中查询
	searchClazzs(params);
}
/**
 * 删除班级
 * @param id
 */
function deleteClazz(bean){
	$.dialog.confirm("您确定要删除吗？","系统提示",function(choose){
		if(choose){
		var id = bean.id;
			var params = "{\"id\":\""+id+"\"}";
			$.postJson("clazz/deleteClazz.do",params,function(result){
				if(result.msg){
					$.dialog.alert(result.msg,null,function(){
						//重新查询
						gotoPage(1);
					});
				}
			});
		}
	});
}
/**
 * 跳转到班级编辑页面
 * @param id
 */
function updateClazz(bean){
	var gid = bean.id;
	window.location = "clazzModifyInfo.jsp?id="+gid;
}


/**
 * 查询班级信息
 * @param params
 */
function searchClazzs(params){
	//如果没有提供条件就相当查询全部
	params = params?params:"{\"pageIndex\":1,\"pageSize\":5}";
	$.postJson("clazz/searchClazzs.do",params,function(result){
		if(result.err) $.dialog.alert(result.err);
		if(result.msg){
			//清除上一次的内容
			$("#table").empty();
			//更新表格数据
			$("#table").appendTable({
				beans:result.objs.clazzs,
				caption:"班级信息表",
				columns:[
				         {name:"编号",column:"id"},
				         {name:"班级名称",column:"clazzName"},
				         {name:"所属年级",column:"grade",contain:false,children:[{name:"年级名称",column:"gradeName"}]},
				         {name:"备注",column:"remark"},
				         {name:"操作",
					          buttons:{
					        	 "修改":updateClazz,
			                	 "删除":deleteClazz,
					         }
				         }
				]
			});
			//分页
			$("#page").empty();
			//更新分页数据
			if(result.objs.pages <= 1) return;//没有查询到数据或只有一页时，不需要分页
			$("#page").appendPagination({
				pageIndex:result.objs.pageIndex,
				pages:result.objs.pages,
				len:5,
				action:gotoPage
			});
		}
	});
}
