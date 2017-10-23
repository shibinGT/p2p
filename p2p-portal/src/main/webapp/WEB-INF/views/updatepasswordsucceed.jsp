<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>p2p网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="static/css/common.css" rel="stylesheet" />
<link href="static/css/register.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="static/script/jquery.min.js"></script>
<script type="text/javascript" src="static/script/common.js"></script>
</head>
<body>
<!-- 页面头部 -->
	<jsp:include page="/top.jsp">
	    <jsp:param value="title" name="apply"/>
	</jsp:include>
<div class="tdbModule register">
    <div class="registerTitle">修改密码</div>
    <div class="registerLc3">
      <p class="p1">填写账户信息</p>
      <p class="p2">验证手机信息</p>
      <p class="p3">修改密码成功</p>
    </div>
    <div class="registerCont">
      <ul>
        <li class="scses"> 恭喜您修改密码成功！<a class="blue" href="#" target="_blank">请立即开通--双乾支付账户,即可投资！</a></li>
        <li class="rz"><a href="#" class="btn">立即开通</a><a href="#" class="blue">进入我的账户</a></li>
      </ul>
    </div>
  </div>
  <!--网站底部-->
    <%@include file="/foot.jsp" %>
</body>
</html>