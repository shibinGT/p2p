<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ include file="/top.jsp"%>
<%@ include file="/left-beforepage.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>用户管理</title>
<meta name="keywords" content="后台管理" />
<meta name="description" content="后台管理" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
	<div class="main-content">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li><i class="icon-home home-icon"></i> <a href="${ctx}/main">首页</a></li>
				<li class="active">用户管理</li>
				<li class="active">新增管理员</li>
			</ul>
			<!-- .breadcrumb -->

			<div class="nav-search" id="nav-search">
				<form class="form-search">
					<span class="input-icon"> <input type="text"
						placeholder="Search ..." class="nav-search-input"
						id="nav-search-input" autocomplete="off" /> <i
						class="icon-search nav-search-icon"></i>
					</span>
				</form>
			</div>
			<!-- #nav-search -->
		</div>

		<div class="page-content">
			<div class="col-xs-12">
				<form action="${ctx}/user/addAdmin" id="registerForm">
					<fieldset>
						<div class="col-md-6 col-md-offset-3">
						<br>
							<label class="block clearfix"> <span
								class="block input-icon input-icon-right"> <input
									class="form-control" placeholder="用户名" id="inputName"
									name="name"> <i class="icon-user"></i> <span
									id="rNameErrors"></span>
							</span>
							</label> <label class="block clearfix"> <span
								class="block input-icon input-icon-right"> <input
									type="password" class="form-control" placeholder="密码"
									id="inputPassword" name="password"> <i
									class="icon-lock"></i> <span id="rPasswordErrors"></span>
							</span>
							</label> <label class="block clearfix"> <span
								class="block input-icon input-icon-right"> <input
									type="password" class="form-control" placeholder="确认密码"
									id="inputPassword2"> <i class="icon-retweet"></i> <span
									id="rPassword2Errors"></span>
							</span><br>
							</label> 
							<!-- 分配角色 Begin -->
							<span class="lbl">分配角色：</span>
							<div style="clear: both;"></div>
							<c:forEach items="${roles}" var="role">
								<div class="col-xs-6 col-md-3">
									<label class="block">
										<input type="checkbox" name="roleid" class="ace" value="${role.id}"> 
										<span class="lbl">${role.roleDesc}</span>
									</label>
								</div>
							</c:forEach><br />
							<!-- 分配角色 End -->
							<div style="clear: both;"></div><hr />
							<label class="block"> <input type="checkbox" class="ace"
								id="agreeCheckbox"> <span class="lbl"> 我同意 <a
									href="#">用户条例</a>
							</span>
							</label>

							<div class="space-24"></div>

							<div class="clearfix">
								<button type="reset" class="width-45 pull-left btn btn-sm">
									<i class="icon-refresh"></i> 重置
								</button>
								<button type="button"
									class="width-50 pull-right btn btn-sm btn-success"
									id="registerSubmit" disabled="disabled">
									注册 <i class="icon-arrow-right icon-on-right"></i>
								</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>



		</div>

	</div>
	<!-- /.main-content -->


	<script src="${ctx}/static/assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="${ctx}/static/assets/js/excanvas.min.js"></script>
		<![endif]-->

	<script src="${ctx}/static/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="${ctx}/static/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="${ctx}/static/assets/js/jquery.slimscroll.min.js"></script>
	<script src="${ctx}/static/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="${ctx}/static/assets/js/jquery.sparkline.min.js"></script>
	<script src="${ctx}/static/assets/js/flot/jquery.flot.min.js"></script>
	<script src="${ctx}/static/assets/js/flot/jquery.flot.pie.min.js"></script>
	<script src="${ctx}/static/assets/js/flot/jquery.flot.resize.min.js"></script>
	<script src="${ctx}/static/assets/js/indexLoginAndRegister.js"></script>
	<script src="${ctx}/static/assets/js/md5.js"></script>


</body>
<%@ include file="/left-afterpage.jsp"%>
<%@ include file="/bottom.jsp"%>
</html>

