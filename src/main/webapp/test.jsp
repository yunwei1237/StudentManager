<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>测试</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@ include file="/html/bootstrap.html"%>
<link rel="stylesheet" href="css/common.css" type="text/css"></link>
<script type="text/javascript" src="js/myjs/test.js"></script>
<script type="text/javascript" src="js/myjs/personAddInfo.js"></script>
<!-- <script type="text/javascript">
	$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	  $("#frm_addPersonnel").validate({
		errorClass:"text-danger",
		submitHandler:function(form){
			var params = $("#frm_addPersonnel").serializeObject(); 
			params = params.replace(".","\.");
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
				maxlength : 50
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
				maxlength : "账号至多由50个字符组成"
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
});
</script> -->
</head>

<body>
	<!-- <form id="frm" action="">
		<p>账户：<input name="username" /></p>
		<p>账户：<input name="username" /></p>
		<p>账户：<input name="username" /></p>
		<p>账户：<input name="username" /></p>
		<p>密码：<input name="password" /></p>
		<p>省份：<input name="address.province" /></p>
		<p>城市：<input name="address.city" /></p>
		<p>电脑CPU名称：<input name="computer.cpu.name" /></p>
		<p>电脑CPU频率：<input name="computer.cpu.speed" /></p>
		<p>电脑CPU频率：<input name="computer.cpu.speed" /></p>
		<p>电脑缓存：<input name="computer.chache" /></p>
		<p>电脑硬盘大小：<input name="computer.disk" /></p>
		<p><input type="button" value="查询"/></p>
	</form> -->
	<!-- <div id="page"></div> -->
	<!-- <form class="cmxform" id="signupForm" method="post" action="">
	  <fieldset>
	    <legend>验证完整的表单</legend>
	    <p>
	      <label for="firstname">名字</label>
	      <input id="firstname" name="firstname" type="text">
	    </p>
	    <p>
	      <label for="lastname">姓氏</label>
	      <input id="lastname" name="lastname" type="text">
	    </p>
	    <p>
	      <label for="username">用户名</label>
	      <input id="username" name="username" type="text">
	    </p>
	    <p>
	      <label for="password">密码</label>
	      <input id="password" name="password" type="password">
	    </p>
	    <p>
	      <label for="confirm_password">验证密码</label>
	      <input id="confirm_password" name="confirm_password" type="password">
	    </p>
	    <p>
	      <label for="email">Email</label>
	      <input id="email" name="email" type="email">
	    </p>
	    <p>
	      <label for="agree">请同意我们的声明</label>
	      <input type="checkbox" class="checkbox" id="agree" name="agree">
	    </p>
	    <p>
	      <label for="newsletter">我乐意接收新信息</label>
	      <input type="checkbox" class="checkbox" id="newsletter" name="newsletter">
	    </p>
	    <fieldset id="newsletter_topics">
	      <legend>主题 (至少选择两个) - 注意：如果没有勾选“我乐意接收新信息”以下选项会隐藏，但我们这里作为演示让它可见</legend>
	      <label for="topic_marketflash">
	        <input type="checkbox" id="topic_marketflash" value="marketflash" name="topic">Marketflash
	      </label>
	      <label for="topic_fuzz">
	        <input type="checkbox" id="topic_fuzz" value="fuzz" name="topic">Latest fuzz
	      </label>
	      <label for="topic_digester">
	        <input type="checkbox" id="topic_digester" value="digester" name="topic">Mailing list digester
	      </label>
	      <label for="topic" class="error">Please select at least two topics you'd like to receive.</label>
	    </fieldset>
	    <p>
	      <input class="submit" type="submit" value="提交">
	    </p>
	  </fieldset>
	</form> -->
	<form id="frm_addPersonnel" class="form-horizontal" role="form">
		<h4 class="text-center"><strong>添加学生信息</strong></h4><br/>
		<div class="form-group">
			<label for="account" class="col-sm-offset-2 col-sm-2 control-label">账号</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="account" name="account" placeholder="请输入账号">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-offset-2 col-sm-2 control-label">密码</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
			</div>
		</div>
		<div class="form-group">
			<label for="password2" class="col-sm-offset-2 col-sm-2 control-label">确认密码</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="password2" name="password2" placeholder="请输入密码">
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-offset-2 col-sm-2 control-label">姓名</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
			</div>
		</div>
		<div class="form-group">
			<label for="clazz.id" class="col-sm-offset-2 col-sm-2 control-label">班级</label>
			<div class="col-sm-4">
				<select id="clazz.id" name="clazz.id" class="form-control">
					<option value="0">全部</option>
					<option value="1">378班</option>
					<option value="2">379班</option>
					<option value="3">380班</option>
					<option value="4">381班</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
		    	<button type="submit" class="btn btn-primary col-sm-3">添加</button>
		    </div>
		</div>
</form>
</body>
</html>
