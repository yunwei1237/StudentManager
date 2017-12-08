<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>学生管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@ include file="/html/bootstrap.html"%>
<link rel="stylesheet" href="css/common.css" type="text/css"></link>
<script type="text/javascript" src="js/myjs/index.js"></script>
</head>

<body>
	<div class="container" style="width:80%;">
		<div></div>
		<%@ include file="html/head.jsp" %>
		<div class="content">
			<form id="frm_login" class="form-horizontal" role="form">
				<div class="form-group">
					<div class="col-xs-7 col-xs-offset-1 col-sm-7 col-sm-offset-2">
						<input type="text" class="form-control" id="name" placeholder="请输入姓名">
					</div>
					<button type="button" id="btn_login" class="col-sm-1 col-xs-2 btn btn-primary" >查询</button>
				</div>
			</form>
			<div class="table-responsive">
				<table id="personals" class="table table-hover">
					<caption class="text-center"><strong>人员信息表</strong></caption>
					<thead>
						<tr>
							<th class="hide">编号</th>
							<th>账号</th>
							<th>姓名</th>
							<th>头衔</th>
							<th>班级</th>
							<th>积分</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="hide">1</td>
							<td>kb2005</td>
							<td>张三</td>
							<td>青铜</td>
							<td>378</td>
							<td>500</td>
						</tr>
						<tr>
							<td class="hide">2</td>
							<td>kb2005</td>
							<td>张三</td>
							<td>青铜</td>
							<td>378</td>
							<td>500</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<%@ include file="html/foot.jsp" %>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>
