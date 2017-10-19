<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>登录</title>
		<meta name="keywords" content="管理系统" />
		<meta name="description" content="管理系统" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<!-- basic styles -->

		
		<link rel="stylesheet" href="${ctx}/static/assets/css/font-awesome.min.css" />

		<link rel="stylesheet" href="${ctx}/static/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${ctx}/static/assets/css/ace-rtl.min.css" />
		<script type="text/ecmascript" src="${ctx }/static/js/md5.js"></script>

	</head>

	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">yrd后台管理系统</span>
									<span class="white">Application</span>
								</h1>
								<h4 class="blue"></h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												登录
											</h4>

											<div class="space-6"></div>

											<form:form action="${ctx}/login" modelAttribute="employee" id="loginForm">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="employeeAccountNumber" cssClass="form-control" placeholder="用户名"/>
															<i class="icon-user"></i>
															<form:errors path="employeeAccountNumber"></form:errors>
															<c:if test="${loginFail==true }">
																<span id="login.errors" style="color: red">用户名或者密码错误</span>
															</c:if>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:password path="employeePassword" cssClass="form-control" placeholder="密码"/>
															<i class="icon-lock"></i>
															<form:errors path="employeePassword"></form:errors>
															<c:out value="${errorMsg}"></c:out>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> 记住我</span>
														</label>

														<button type="button" class="width-35 pull-right btn btn-sm btn-primary" id="loginSubmint">
															<i class="icon-key"></i>
															登录
														</button>
														
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form:form>
										</div><!-- /widget-main -->
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

<!-- 注册用的js(独立出了单独的js) -->		
<script type="text/javascript" src="${ctx }/static/assets/js/indexLoginAndRegister.js"></script>




</body>
</html>
