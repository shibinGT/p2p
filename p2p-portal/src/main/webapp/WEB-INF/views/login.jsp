<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>p2p网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<!-- 页面头部 -->
	<jsp:include page="/top.jsp">
	    <jsp:param value="title" name="apply"/>
	</jsp:include>
	<script type="text/javascript" src="${ctx}/static/script/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx}/static/script/messages_zh.js"></script>
<script src="${ctx}/static/script/login.js" type="text/javascript"></script>	
<script src="${ctx}/static/script/md5.js" type="text/javascript"></script>
<style>
.error{
	color:red;
}
</style>
</head>
<body>
<!--登录-->
<div class="wrap">
 <form id="LonginForm" name="LonginForm" action="<%=request.getServletContext().getContextPath()%>/login" method="post">
	<div class="tdbModule loginPage">
		<div class="registerTitle">用户登录</div>
		<div class="registerCont">
			<ul>
				
				<li>
					<span class="dis">用户名：</span><input class="input" type="text"  name="userName" id="userName" maxlength="24" tabindex="1" autocomplete="off"> 
				    <a href="${ctx }/toregister" class="blue">注册用户</a>
				</li>
	                
				<li>
				   <span class="dis">密码：</span><input class="input" type="password" name="userPassword" id="userPassword" maxlength="50" tabindex="1" autocomplete="off">  
				   <a href="${ctx }/toforgetpassword" id="pawHide" class="blue">忘记密码</a>
				</li>
				<li>
				  <span class="dis">验证码：</span><input type="text"  id="jpgVerify" style="width:166px;" class="input" name="jpgVerify" data-msg="验证码" maxlength="4" tabindex="1" autocomplete="off">
						<img alt="验证码" id="scode"
						src="${ctx}/getCode"> <a href="#"
						onclick="javascript:flushCode();">看不清?</a>
				</li>
				<li class="btn"> 
					<input type="button" class="radius1" value="立即登录" id="loginSubmit" />
				</li>
			</ul>
		</div>
	</div>
 </form>
 <span>${islogin }</span>
</div>
<!--网站底部-->
    <%@include file="/foot.jsp" %>
</body>
<script type="text/javascript">
<!-- 验证码 -->
function flushCode() {
    // 每次刷新的时候获取当前时间，防止浏览器缓存刷新失败
    var time = new Date();
    document.getElementById("scode").src = "<%=request.getContextPath()%>/getCode?time="+time;
		}	
</script>
</html>
