<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>p2p网贷平台</title>
<!-- 页面头部 -->
	<jsp:include page="/top.jsp">
	    <jsp:param value="title" name="apply"/>
	</jsp:include>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript" src="${ctx}/static/script/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx}/static/script/messages_zh.js"></script>
<script src="${ctx}/static/script/register.js" type="text/javascript"></script>
<script src="${ctx}/static/script/md5.js" type="text/javascript"></script>
<style>
.error{
	color:red;
}
</style>
</head>
<body>

	<div class="tdbModule register">
		<div class="registerTitle">注册账户</div>
		<div class="registerLc1">
			<p class="p1">填写账户信息</p>
			<p class="p2">验证手机信息</p>
			<p class="p3">注册成功</p>
		</div>
		<div class="registerCont">
			<form action="register" id="registerForm" method="post">
				<ul>
					<li><label for="userName" class="dis">用户名:</label> <input type="text"
						name="userName" id="userName" class="input _userName"
						maxlength="24" tabindex="1"> 
					</li>
					<li><label for="userPassword" class="dis">密码:</label> <input type="password"
						name="userPassword" id="userPassword" class="input _password"
						maxlength="50" tabindex="1"> </li>
					<li><span class="dis">确认密码:</span> <input type="password"
						name="repeatPassword" id="repeatPassword"
						class="input _repeatPassword" maxlength="50" tabindex="1">
						</li>
					<li><span class="dis">验证码:</span> <input type="text"
						id="jpgVerify" class="input input1 _yanzhengma" name="jpgVerify"
						maxlength="4" tabindex="1"> <img alt="验证码" id="scode"
						src="${ctx }/getCode"> <a href="#"
						onclick="javascript:flushCode();">看不清?</a> </li>
					<li class="telNumber"><span class="dis">手机号码:</span> <input
						type="text" class="input _phoneNum" id="userPhone" name="userPhone"
						tabindex="1" maxlength="11"> <a href="javascript:void(0);"
						class="button radius1 _getkey" id="sendPhone">获取验证码</a> </li>
					<li class="telNumber"><span class="dis">短信验证码:</span> <input
						id="phonVerify" name="phonVerify" type="text"
						class="input input1  _phonVerify" data-_id="phonVerify"
						tabindex="1"> </li>
					<li><span class="dis">推 荐 人:</span> <input type="text"
						name="userReferrer" class="input input1 _invist"> <span
						class="_invist_msg">请填写推荐人账户名，如无推荐人请留空</span></li>
					<li class="agree"><input name="protocol" id="protocol"
						type="checkbox" value="yes" checked="checked"> 我同意《 <a
						href="#" target="_black">亿人宝注册协议</a>》 <span id="protocolAlt"
						data-info="请查看协议">请查看协议</span></li>
					<li class="btn"><a
						href="javascript:void(0);" id="registerSubmit">下一步</a></li>
				</ul>
			</form>
		</div>
		<span>${isRegister}</span>
	</div>
	<script type="text/javascript">
<!--刷新验证码 -->
function flushCode() {
    // 每次刷新的时候获取当前时间，防止浏览器缓存刷新失败
    var time = new Date();
    document.getElementById("scode").src = "<%=request.getContextPath()%>/getCode?time="+time;
		}	
//点击获取验证码
$("#sendPhone").click(function() {
	$.ajax({
		type : 'POST',
		url : '<%=request.getServletContext().getContextPath()%>/getSendPhone',
		success : function(data) {
			alert(data);
		}
	})
})	

</script>
<!--网站底部-->
    <%@include file="/foot.jsp" %>
</body>
</html>
