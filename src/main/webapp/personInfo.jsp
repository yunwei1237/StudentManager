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
<script type="text/javascript" src="js/myjs/personInfo.js"></script>
</head>

<body>
	<div class="container" id="container">
		<div></div>
		<%@ include file="html/head.jsp" %>
		<div class="content" style="min-height: 450px">
			<form id="frm_search" class="form-horizontal" role="form">
				<div>
					<c:choose>
						<c:when test="not empty param.pageIndex">
							<!-- 保存当前页码 -->
							<input type="hidden" name="pageIndex" value="${param.pageIndex }" />
						</c:when>
						<c:otherwise>
							<!-- 如果没有就默认为第1页 -->
							<input type="hidden" name="pageIndex" value="1" />
						</c:otherwise>
					</c:choose>
					
					<!-- 每页显示5行 -->
					<input type="hidden" name="pageSize" value="5" />
				</div>
				<div class="form-group">
					<!-- 姓名 -->
					<label for="name" class="col-sm-1 control-label">姓名</label>
					<div class="col-sm-2">
						<input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
					</div>
					<!-- 年级 -->
					<label for=clazz.grade.id class="col-sm-1 control-label">年级</label>
					<div class="col-sm-2">
						<select name="clazz.grade.id" id="clazz.grade.id"  class="form-control"></select>
					</div>
					<!-- 班级 -->
					<label for="clazz.id" class="col-sm-1 control-label">班级</label>
					<div class="col-sm-2">
						<!-- name="title.id" -->
						<select name="clazz.id" id="clazz.id"  class="form-control"></select>
					</div>
					<!-- 查询 -->
					<!-- <div class="col-sm-2 col-xs-2">
						<button type="button" id="btn_search" class="btn btn-primary col-sm-8" >查询</button>
					</div> -->
				</div>
				<div class="form-group">
					<!-- 账号 -->
					<label for="account" class="col-sm-1 control-label">账号</label>
					<div class="col-sm-2">
						<input type="text" name="account" id="account" class="form-control"   placeholder="请输入账号">
					</div>
					<!-- 积分 -->
					<label for="integralRange" class="col-sm-1 control-label">积分</label>
					<div class="col-sm-2">
						<select name="integralRange" id="integralRange" class="form-control">
							<!-- 0-  0-空格 -->
							<option value="0- ">全部</option>
							<c:forEach var="i" begin="0" end="10">
								<option value="${i*100 }-${(i+1)*100 }">${i*100 }-${(i+1)*100 }</option>
							</c:forEach>
						</select>
					</div>
					<!-- 头衔 -->
					<label for="title.id" class="col-sm-1 control-label">头衔</label>
					<div class="col-sm-2">
						<!-- name="title.id" -->
						<select name="title.id" id="title.id"  class="form-control"></select>
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
