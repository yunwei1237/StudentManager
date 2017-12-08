$(function() {
	addGrade();
});

function addGrade() {
	$("#frm_addGrade").validate({
		errorClass:"text-danger",
		/*errorPlacement: function(error, element) {  
		    console.log("error:"+error);
		    console.log("element:"+element);
		    var warn = $("<div class='alert alert-success'></div>");
		    warn.append(error);
		},*/
		submitHandler:function(form){
			var params = $("#frm_addGrade").serializeObject(); 
			$.postJson("grade/addGrade.do",params,function(result){
				if(result.msg){
					$.dialog.alert(result.msg,null,function(){
						$("#frm_addGrade")[0].reset();
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
