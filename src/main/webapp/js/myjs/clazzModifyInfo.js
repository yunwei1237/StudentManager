$(function() {
	getClazz();
	updateClazz();
});

function getClazz(){
	var id = $("#id").val();
	var params = "{\"id\":\""+id+"\"}";
	$.postJson("clazz/getClazz.do",params,function(result){
		var clazz = result.objs.clazz;
		var grades = result.objs.grades;
		if(clazz){
			$("#clazzName").val(clazz.clazzName);
			$("#remark").val(clazz.remark);
			$("#isDelete").val(clazz.isDelete);
		}
		if(grades){
			$("select[name=grade\\.id]").append("<option value='-1'>没有班级信息</option>");
			for(var i in grades){
				var grade = grades[i];
				var select = "";
				if(clazz.grade != null && clazz.grade.id == grade.id){
					select = "selected='selected'";
				}
				$("select[name=grade\\.id]").append("<option value='"+grade.id+"' "+select+" >"+grade.gradeName+"</option>");
			}
		}
	});
}

function updateClazz() {
	$("#frm_updateClazz").validate({
		errorClass:"text-danger",
		submitHandler:function(form){
			var params = $("#frm_updateClazz").serializeObject(); 
			$.postJson("clazz/updateClazz.do",params,function(result){
				if(result.msg){
					$.dialog.alert(result.msg,null,function(){
						window.location = "clazzInfo.jsp";
					});
				}
				if(result.err){
					$.dialog.alert(result.err);
				}
			});
        },
		rules : {
			clazzName : {
				required : true,
				minlength : 2,
				maxlength : 200
			},
			"grade.id":{
				required : true,
				min:1
			},
			remark : {
				maxlength : 500
			}
		},
		messages : {
			clazzName : {
				required: "请输入班级名称",
				minlength: "班级名称最少2个字符",
				maxlength:"班级名称最多200个字符"
			},
			"grade.id":{
				required : "请选择年级",
				min:"请选择有效的年级"
			},
			remark : {
				maxlength : "备注最多500个字符",
			}
		}
	});
}