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
					<!-- 类型 -->
					<label for="firstname" class="col-sm-1 control-label">规则类型</label>
					<div class="col-sm-2">
						<select class="form-control">
							<option value="0">全部</option>
							<option value="1">作业</option>
							<option value="2">考试</option>
							<option value="3">班干</option>
							<option value="4">纪律</option>
							<option value="5">活动</option>
						</select>
					</div>
					<!-- 开始时间 -->
					<label for="firstname" class="col-sm-1 control-label">起始时间</label>
					<div class="col-sm-2">
						<input type="date" class="form-control" id="account" placeholder="请输入账号">
					</div>
					<!-- 结束时间 -->
					<label for="firstname" class="col-sm-1 control-label">截止时间</label>
					<div class="col-sm-2">
						<input type="date" class="form-control" id="account" placeholder="请输入账号">
					</div>
					<!-- 查询 -->
					<button type="button" id="btn_login" class="btn btn-primary col-sm-1" >查询</button>
				</div>
			</form>
			<div class="table-responsive">
				<table id="personals" class="table table-hover">
					<caption class="text-center"><strong>人员规则记录表</strong></caption>
					<thead>
						<tr>
							<th class="hide">编号</th>
							<th>被操作者</th>
							<th>规则</th>
							<th>积分</th>
							<th>提交人</th>
							<th>审批人</th>
							<th>提交时间</th>
							<th>审批时间</th>
							<th>审批状态</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="hide">1</td>
							<td>李四</td>
							<td>作业</td>
							<td>-2</td>
							<td>张三</td>
							<td>王老师</td>
							<td>2017-4-5</td>
							<td>2017-5-7</td>
							<td>通过</td>
							<td>无</td>
						</tr>
						<tr>
							<td class="hide">1</td>
							<td>李四</td>
							<td>作业</td>
							<td>-2</td>
							<td>张三</td>
							<td>王老师</td>
							<td>2017-4-5</td>
							<td>2017-5-7</td>
							<td>通过</td>
							<td>无</td>
						</tr>
						<tr>
							<td class="hide">1</td>
							<td>李四</td>
							<td>作业</td>
							<td>-2</td>
							<td>张三</td>
							<td>王老师</td>
							<td>2017-4-5</td>
							<td>2017-5-7</td>
							<td>通过</td>
							<td>无</td>
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
