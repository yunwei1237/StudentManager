$(function() {
	searchGrades();
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
	searchGrades(params);
}
/**
 * 删除年级
 * @param id
 */
function deleteGrade(bean){
	$.dialog.confirm("您确定要删除吗？","系统提示",function(choose){
		if(choose){
			var gid = bean.id;
			var params = "{\"id\":\""+gid+"\"}";
			$.postJson("grade/deleteGrade.do",params,function(result){
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
 * 跳转到年级编辑页面
 * @param id
 */
function updateGrade(bean){
	var gid = bean.id;
	window.location = "gradeModifyInfo.jsp?id="+gid;
}


/**
 * 查询年级信息
 * @param params
 */
function searchGrades(params){
	//如果没有提供条件就相当查询全部
	params = params?params:"{\"pageIndex\":1,\"pageSize\":5}";
	$.postJson("grade/searchGrades.do",params,function(result){
		if(result.err) $.dialog.alert(result.err);
		if(result.msg){
			//清除上一次的内容
			$("#table").empty();
			//更新表格数据
			$("#table").appendTable({
				beans:result.objs.grades,
				caption:"年级信息表",
				columns:[
				         {name:"编号",column:"id"},
				         {name:"年级名称",column:"gradeName"},
				         {name:"备注",column:"remark"},
				         {name:"操作",
					          buttons:{
					        	 "修改":updateGrade,
			                	 "删除":deleteGrade,
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
