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

											<div class="social-or-login center">
												<span class="bigger-110">使用第三方登录</span>
											</div>

											<div class="social-login center">
												<a class="btn btn-primary">
													<i class="icon-facebook"></i>
												</a>

												<a class="btn btn-info">
													<i class="icon-twitter"></i>
												</a>

												<a class="btn btn-danger">
													<i class="icon-google-plus"></i>
												</a>
											</div>
										</div><!-- /widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
													<i class="icon-arrow-left"></i>
													忘记密码？
												</a>
											</div>

											<div>
												<a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
													我要注册
													<i class="icon-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /login-box -->

								<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header red lighter bigger">
												<i class="icon-key"></i>
												Retrieve Password
											</h4>

											<div class="space-6"></div>
											<p>
												Enter your email and to receive instructions
											</p>

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="Email" />
															<i class="icon-envelope"></i>
														</span>
													</label>

													<div class="clearfix">
														<button type="button" class="width-35 pull-right btn btn-sm btn-danger">
															<i class="icon-lightbulb"></i>
															Send Me!
														</button>
													</div>
												</fieldset>
											</form>
										</div><!-- /widget-main -->

										<div class="toolbar center">
											<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
												Back to login
												<i class="icon-arrow-right"></i>
											</a>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /forgot-box -->
//<!-- 用户注册页面 -->
								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="icon-group blue"></i>
												用户注册
											</h4>

											<div class="space-6"></div>
											<p> 输入您的详细信息: </p>

                                            <form action="${ctx}/user/register" id="registerForm">
												<fieldset>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
														    <input class="form-control" placeholder="用户名" id="inputName" name="name"/>
															<i class="icon-user"></i>
															<span id="rNameErrors" ></span>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
														    <input type="password" class="form-control" placeholder="密码" id="inputPassword" name="password" />  
															<i class="icon-lock"></i>
															<span id="rPasswordErrors" ></span>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="确认密码" id="inputPassword2" />
															<i class="icon-retweet"></i>
															<span id="rPassword2Errors" ></span>
														</span>
													</label>

													<label class="block">
														<input type="checkbox" class="ace" id="agreeCheckbox" />
														<span class="lbl">
															我同意
															<a href="#">用户条例</a>
														</span>
													</label>

													<div class="space-24"></div>

													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="icon-refresh"></i>
															重置
														</button>
														<button type="button" class="width-65 pull-right btn btn-sm btn-success" id="registerSubmit" disabled="disabled">
															注册
															<i class="icon-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
												<i class="icon-arrow-left"></i>
												已有帐号，去登录
											</a>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /signup-box -->
//<!-- /用户注册页面 -->
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
