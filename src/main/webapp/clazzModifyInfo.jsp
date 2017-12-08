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

<title>修改学生信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%@ include file="/html/bootstrap.html"%>
<link rel="stylesheet" href="css/common.css" type="text/css"></link>
<script type="text/javascript" src="js/myjs/clazzModifyInfo.js"></script>
</head>

<body>
	<div class="container" style="width:80%;">
		<%@ include file="html/head.jsp" %>
		<div class="content" style="min-height: 450px">
			<form id="frm_updateClazz" class="form-horizontal" role="form">
					<div>
						<input type="hidden" id="id" name="id" value="${param.id }"/>
						<input type="hidden" id="isDelete" name="isDelete"/>
					</div>
					<h4 class="text-center"><strong>编辑班级信息</strong></h4><br/>
					<div class="form-group">
						<label for="firstname" class="col-sm-offset-2 col-sm-2 control-label">班级名称</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="clazzName" name="clazzName" placeholder="请输入班级名称">
						</div>
					</div>
					<div class="form-group">
						<label for="gradeId" class="col-sm-offset-2 col-sm-2 control-label">年级</label>
						<div class="col-sm-4">
							<select class="form-control" id="gradeId" name="grade.id"></select>
						</div>
					</div>
					<div class="form-group">
						<label for="firstname" class="col-sm-offset-2 col-sm-2 control-label">备注</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="remark" name="remark" placeholder="请输入备注">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-4">
					    	<button id="save" type="submit" class="btn btn-primary col-sm-3">保存</button>
					    </div>
					</div>
				</form>
		</div>
		<%@ include file="html/foot.jsp" %>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>
