$(function() {
	getGrade();
	updateGrade();
});

function getGrade(){
	var id = $("#id").val();
	var params = "{\"id\":\""+id+"\"}";
	$.postJson("grade/getGrade.do",params,function(result){
		if(result.objs){
			$("#gradeName").val(result.objs.gradeName);
			$("#remark").val(result.objs.remark);
			$("#isDelete").val(result.objs.isDelete);
		}
	});
}
function updateGrade(){
	$("#frm_updateGrade").validate({
		errorClass:"text-danger",
		submitHandler:function(form){
			var params = $("#frm_updateGrade").serializeObject(); 
			$.postJson("grade/updateGrade.do",params,function(result){
				if(result.msg){
					$.dialog.alert(result.msg,null,function(){
						window.location = "gradeInfo.jsp";
					});
				}
				if(result.err){
					$.dialog.alert(result.err);
				}
			});
        },
		rules : {
			gradeName : {
				required : true,
				minlength : 2,
				maxlength : 200
			},
			remark : {
				maxlength : 500
			}
		},
		messages : {
			gradeName : {
				required: "请输入年级名称",
				minlength: "年级名称最少2个字符",
				maxlength:"年级名称最多200个字符"
			},
			remark : {
				maxlength : "备注最多500个字符",
			}
		}
	});
}