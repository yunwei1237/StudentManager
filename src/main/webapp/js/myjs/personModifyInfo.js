$(function() {
	getPersonnel();
	updatePersonnel();
});

function getPersonnel(){
	var id = $("#id").val();
	var params = "{\"id\":\""+id+"\"}";
	$.postJson("person/getPersonnel.do",params,function(result){
		var person = result.objs.person;
		var clazzs = result.objs.clazzs;
		if(person){
			$("#name").val(person.name);
			$("#remark").val(person.remark);
			$("#isDelete").val(person.isDelete);
			$("#clazz\\.id").attr("data-clazzId",person.clazz.id);
		}
		if(clazzs){
			var id = $("#clazz\\.id").attr("data-clazzId");
			$("select[name=clazz\\.id]").append("<option value='0'>请选择班级</option>");
			for(var i = 0;i<clazzs.length;i++){
				var clazz = clazzs[i];
				var select = "";
				if(clazz.id == id){
					select = "selected='selected'";
				}
				$("select[name=clazz\\.id]").append("<option value='"+clazz.id+"'  "+select+">"+clazz.clazzName+"</option>");
			}
		}
	});
}

function updatePersonnel() {
	$("#frm_updatePersonnel").validate({
		errorClass:"text-danger",
		submitHandler:function(form){
			var params = $("#frm_updatePersonnel").serializeObject(); 
			console.log(params);
			$.postJson("person/updatePersonnel.do",params,function(result){
				if(result.msg){
					$.dialog.alert(result.msg,null,function(){
						window.location = "personInfo.jsp";
					});
				}
				if(result.err){
					$.dialog.alert(result.err);
				}
			});
        },
        rules : {
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
