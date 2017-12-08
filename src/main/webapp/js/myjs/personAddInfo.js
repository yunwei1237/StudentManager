$(function() {
	addPersonnel();
	initClazz();
});

function addPersonnel() {
	$("#frm_addPersonnel").validate({
		errorClass:"text-danger",
		submitHandler:function(form){
			var params = $("#frm_addPersonnel").serializeObject(["password2"]); 
			$.postJson("person/addPersonnel.do",params,function(result){
				if(result.msg){
					$.dialog.alert(result.msg,null,function(){
						$("#frm_addPersonnel")[0].reset();
					});
				}
				if(result.err){
					$.dialog.alert(result.err);
				}
			});
        },
		rules : {
			account : {
				required: true,
				minlength : 4,
				maxlength : 50,
				remote:{//验证用户名是否存在
	               type:"POST",
	               url:"person/checkAccount.do",
	               /*data:{
	            	   name:function(){
	            		   alert($("#account").val());
	            		   return $("#account").val();
	            	   }
	               }*/
		       } 
			},
			password : {
				required: true,
				minlength : 4,
				maxlength : 50
			},
			password2: {
				required : true,
				minlength : 4,
				maxlength : 50,
				equalTo : "#password"
			},
			name: {
				required : true,
				minlength : 2,
				maxlength : 200
			},
			"clazz.id": {
				required : true,
				min:1
			},
			remark: {
				maxlength : 500
			}
		},
		messages : {
			account : {
				required : "请输入账号",
				minlength : "账号至少由2个字符组成",
				maxlength : "账号至多由50个字符组成",
				remote:"账号已经存在"
			},
			password : {
				required : "请输入密码",
				minlength : "密码至少由4个字符组成",
				maxlength : "密码至多由50个字符组成"
			},
			password2 : {
				required : "请输入确认密码",
				minlength : "密码至少由4个字符组成",
				maxlength : "密码至多由50个字符组成",
				equalTo:"两次密码不一致"
			},
			name : {
				required : "请输入姓名",
				minlength : "姓名至少由2个字符组成",
				maxlength : "姓名至多由200个字符组成",
			},
			"clazz.id" : {
				required : "请选择班级",
				min:"请选择有效的班级"
			},
			remark : {
				maxlength : "备注最多500个字符",
			}
		}
	});
}

function initClazz(){
	$.postJson("clazz/getAllClazzs.do","{}",function(result){
		if(result.objs.clazzs){
			var clazzs = result.objs.clazzs;
			$("select[name=clazz\\.id]").append("<option value='0'>请选择班级</option>");
			for(var i = 0;i<clazzs.length;i++){
				var clazz = clazzs[i];
				$("select[name=clazz\\.id]").append("<option value='"+clazz.id+"'>"+clazz.clazzName+"</option>");
			}
		}
	});
}
