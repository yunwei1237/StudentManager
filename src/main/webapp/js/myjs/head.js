$(function() {
	//设置登录窗口的特性
    $("#login").modal({
        keyboard: true,
        show:false
    });
    $("#btn_login").click(function(){
    	//收集信息
    	var account = $("#account").val();
    	var password = $("#password").val();
    	var str = "您输入的账户："+account+"\n您输入的密码："+password;
    	alert(str);
    	//关闭窗口
    	$("#login").modal("hide");
    	//清空登录字段的值
    	$("#frm_login").get(0).reset();
    });
});