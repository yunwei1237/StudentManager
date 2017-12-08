$(function() {
	addClazz();
	initGrade();
});

function addClazz() {
	$("#frm_addClazz").validate({
		errorClass:"text-danger",
		submitHandler:function(form){
			var params = $("#frm_addClazz").serializeObject(); 
			params = params.replace(".","\.");
			$.postJson("clazz/addClazz.do",params,function(result){
				if(result.msg){
					$.dialog.alert(result.msg,null,function(){
						$("#frm_addClazz")[0].reset();
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
			remark : {
				maxlength : "备注最多500个字符",
			}
		}
	});
}

function initGrade(){
	$.postJson("clazz/getAllClazzs.do","{}",function(result){
		if(result.objs.clazzs){
			var clazzs = result.objs.clazzs;
			for(var i in clazzs){
				var clazz = clazzs[i];
				$("select[name=grade\\.id]").append("<option value='"+clazz.id+"'>"+clazz.clazzName+"</option>");
			}
		}
	});
}
