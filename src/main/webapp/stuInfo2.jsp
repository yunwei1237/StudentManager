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
					<!-- 姓名 -->
					<label for="firstname" class="col-sm-1 control-label">姓名</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="name" placeholder="请输入姓名">
					</div>
					<!-- 班级 -->
					<label for="firstname" class="col-sm-1 control-label">班级</label>
					<div class="col-sm-2">
						<select class="form-control">
							<option value="0">全部</option>
							<option value="1">378班</option>
							<option value="2">379班</option>
							<option value="3">380班</option>
							<option value="4">381班</option>
						</select>
					</div>
					<!-- 头衔 -->
					<label for="firstname" class="col-sm-1 control-label">头衔</label>
					<div class="col-sm-2">
						<select class="form-control">
							<option value="0">全部</option>
							<option value="1">伟大的王者</option>
							<option value="2">无敌的钻石</option>
							<option value="3">尊敬的铂金</option>
							<option value="4">英勇的黄金</option>
							<option value="4">普通的白银</option>
							<option value="4">稍菜的青铜</option>
							<option value="4">英勇的黄金</option>
							<option value="4">极差的无名</option>
						</select>
					</div>
					<!-- 结束时间 -->
					<!-- <label for="firstname" class="col-sm-1 control-label">截止时间</label>
					<div class="col-sm-2">
						<input type="date" class="form-control" id="account" placeholder="请输入账号">
					</div> -->
					<!-- 查询 -->
					<div class="col-sm-2">
						<button type="button" id="btn_login" class="btn btn-primary col-sm-8" >查询</button>
					</div>
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
							<td>普通的白银</td>
							<td>378</td>
							<td>500</td>
						</tr>
						<tr>
							<td class="hide">2</td>
							<td>kb2005</td>
							<td>张三</td>
							<td>普通的白银</td>
							<td>378</td>
							<td>500</td>
						</tr>
						<tr>
							<td class="hide">2</td>
							<td>kb2005</td>
							<td>张三</td>
							<td>普通的白银</td>
							<td>378</td>
							<td>500</td>
						</tr>
					</tbody>
				</table>
				<div class="text-center">
					<ul class="pagination">
					    <li><a href="#">&laquo;</a></li>
					    <li class="active"><a href="#">1</a></li>
					    <li class="disabled"><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">4</a></li>
					    <li><a href="#">5</a></li>
					    <li><a href="#">&raquo;</a></li>
					</ul>
				</div>
			</div>
		</div>
		<%@ include file="html/foot.jsp" %>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>
