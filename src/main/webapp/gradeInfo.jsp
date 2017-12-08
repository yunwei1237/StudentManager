<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script type="text/javascript" src="js/myjs/gradeInfo.js"></script>
</head>

<body>
	<div class="container" style="width:80%;">
		<div></div>
		<%@ include file="html/head.jsp" %>
		<div class="content" style="min-height: 450px">
			<form id="frm_search" class="form-horizontal" role="form">
				<div>
					<c:choose>
						<c:when test="not empty param.pageIndex">
							<input type="hidden" name="pageIndex" value="${param.pageIndex }" />
						</c:when>
						<c:otherwise>
							<input type="hidden" name="pageIndex" value="1" />
						</c:otherwise>
					</c:choose>
					
					<!-- 每页显示5行 -->
					<input type="hidden" name="pageSize" value="5" />
				</div>
				<div class="form-group">
					<!-- 姓名 -->
					<label for="firstname" class="col-sm-1 control-label">年级名称</label>
					<div class="col-sm-2 col-xs-9">
						<input type="text" class="form-control" id="gradeName" name="gradeName" placeholder="请输入年级名称">
					</div>
					<!-- 查询 -->
					<div class="col-sm-2 col-xs-2">
						<button type="button" id="btn_search" class="btn btn-primary col-sm-8" >查询</button>
					</div>
				</div>
			</form>
			<div id="table"></div>
		</div>
		<div id="page"></div>
		<%@ include file="html/foot.jsp" %>
	</div>
</body>
</html>
