<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="js/myjs/head.js"></script>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 导航 -->
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#example-navbar-collapse">
				<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">首页</a>
		</div>
		<div class="collapse navbar-collapse" id="example-navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><strong>人员管理</strong><b class="caret"></b> </a>
					<ul class="dropdown-menu">
						<li><a href="personInfo.jsp">查看人员信息</a></li>
						<li><a href="personAddInfo.jsp">添加人员信息</a></li>
						<li class="divider"></li>
						<li><a href="#">提交人员处理</a></li>
						<li><a href="#">审核人员处理</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><strong>班级管理</strong><b class="caret"></b> </a>
					<ul class="dropdown-menu">
						<li><a href="clazzInfo.jsp">查看班级信息</a></li>
						<li><a href="clazzAddInfo.jsp">添加班级信息</a></li>
						<li class="divider"></li>
						<li><a href="gradeInfo.jsp">查看年级信息</a></li>
						<li><a href="gradeAddInfo.jsp">添加年级信息</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><strong>规则管理</strong><b class="caret"></b> </a>
					<ul class="dropdown-menu">
						<li><a href="#">查看规则信息</a></li>
						<li class="divider"></li>
						<li><a href="#">添加规则信息</a></li>
						<li><a href="#">修改规则信息</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><strong>角色管理</strong><b class="caret"></b> </a>
					<ul class="dropdown-menu">
						<li><a href="#">查看角色信息</a></li>
						<li class="divider"></li>
						<li><a href="#">添加角色信息</a></li>
						<li><a href="#">修改角色信息</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><strong>系统管理</strong><b class="caret"></b> </a>
					<ul class="dropdown-menu">
						<li><a href="#">数据词典管理</a></li>
						<li><a href="#">系统相关设置</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" data-toggle="modal" data-target="#login"><span class="glyphicon glyphicon-log-in"></span>登录</a></li>
				<li><a href="#"><span class="text-primary" style="font-weight: bolder;">王平</span>【管理员】</a></li>
			</ul>
		</div>
	</div>
</nav>
	
<!-- 登录 -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel"><strong>登录</strong></h4>
            </div>
            <div class="modal-body">
				<form id="frm_login" class="form-horizontal" role="form">
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">账号</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="account" placeholder="请输入账号">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" placeholder="请输入密码">
						</div>
					</div>
				</form>
			</div>
            <div class="modal-footer">
                <button type="button" id="btn_login" class="btn btn-primary" >登录</button>
                <!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> -->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
