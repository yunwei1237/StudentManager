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

<title>添加班级信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@ include file="/html/bootstrap.html"%>
<link rel="stylesheet" href="css/common.css" type="text/css"></link>
<script type="text/javascript" src="js/myjs/personAddInfo.js"></script>
</head>

<body>
	<div class="container" style="width:80%;">
		<div></div>
		<%@ include file="html/head.jsp" %>
		<div class="content" style="min-height: 450px">
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
							<select id="clazz.id" name="clazz.id" class="form-control"></select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-4">
					    	<button type="submit" class="btn btn-primary col-sm-3">添加</button>
					    </div>
					</div>
			</form>
		</div>
		<%@ include file="html/foot.jsp" %>
	</div>
</body>
</html>
