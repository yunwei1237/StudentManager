$(function() {
	searchPersonnels();
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
	var params = $("#frm_search").serializeObject([],["0"]); 
	//去数据库中查询
	searchPersonnels(params);
}
/**
 * 删除人员
 * @param id
 */
function deletePersonnel(bean){
	$.dialog.confirm("您确定要删除吗？","系统提示",function(choose){
		if(choose){
		var id = bean.id;
			var params = "{\"id\":\""+id+"\"}";
			$.postJson("person/deletePersonnel.do",params,function(result){
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
 * 跳转到人员编辑页面
 * @param id
 */
function updatePersonnel(bean){
	var gid = bean.id;
	window.location = "personModifyInfo.jsp?id="+gid;
}
/**
 * 查询人员信息
 * @param params
 */
function searchPersonnels(params){
	//如果没有提供条件就相当查询全部
	params = params?params:"{\"pageIndex\":1,\"pageSize\":5}";
	$.postJson("person/searchPersonnels.do",params,function(result){
		if(result.err) $.dialog.alert(result.err);
		if(result.msg){
			//初始化年级列表
			if(result.objs.grades){
				var grades = result.objs.grades;
				var gradeId = result.objs.gradeId;
				var clazzId = result.objs.clazzId;
				$("select[name=clazz\\.grade\\.id]").empty().append("<option value='0'>全部年级</option>");
				for(var i = 0;i<grades.length;i++){
					var grade = grades[i];
					var select = "";
					if(grade.id == gradeId){
						select = "selected='selected'";
					}
					$("select[name=clazz\\.grade\\.id]").append("<option value='"+grade.id+"' "+select+" >"+grade.gradeName+"</option>");
				}
				//更新班级列表
				bindClazz(gradeId,clazzId);
				//初始化班级
				$("select[name=clazz\\.grade\\.id]").change(function(event){
					var id = $(this).val();
					bindClazz(id,clazzId);
				});
			}
			//初始化头衔
			if(result.objs.titles){
				var titles = result.objs.titles;
				var titleId = result.objs.titleId;
				$("select[name=title\\.id]").empty().append("<option value='0'>全部</option>");
				for(var i = 0;i<titles.length;i++){
					var title = titles[i];
					var select = "";
					if(title.id == titleId){
						select = "selected='selected'";
					}
					$("select[name=title\\.id]").append("<option value='"+title.id+"' "+select+" >"+title.titleName+"</option>");
				}
			}
			//清除上一次的内容
			$("#table").empty();
			//更新表格数据
			$("#table").appendTable({
				beans:result.objs.persons,
				caption:"人员信息表",
				columns:[
				         {name:"编号",column:"id"},
				         {name:"姓名",column:"name",ellipsis:true},
				         {name:"账号",column:"account"},
				         {name:"所属班级",column:"clazz",children:[{name:"班级名称",column:"clazzName"},{name:"年级名称",column:"grade",children:[{name:"年级名称",column:"gradeName"}]}]},
				         {name:"头衔",column:"title",children:[{name:"头衔名称",column:"titleName"}]},
				         {name:"积分",column:"integral"},
				         {name:"备注",column:"remark"},
				         {name:"操作",
					          buttons:{
					        	 "修改":updatePersonnel,
			                	 "删除":deletePersonnel,
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

function bindClazz(gradeId,clazzId){
	var params = JSON.stringify({grade:{"id":gradeId}});
	$.postJson("clazz/searchClazzs.do",params,function(result){
		if(result.err) $.dialog.alert(result.err);
		if(result.msg){
			if(result.objs.clazzs){
				var clazzs = result.objs.clazzs;
				$("select[name=clazz\\.id]").empty().append("<option value='0'>全部班级</option>");
				for(var i = 0;i<clazzs.length;i++){
					var clazz = clazzs[i];
					var select = "";
					if(clazz.id == clazzId){
						select = "selected='selected'";
					}
					$("select[name=clazz\\.id]").append("<option value='"+clazz.id+"' "+select+">"+clazz.clazzName+"</option>");
				}
			}
		}
	});
}
