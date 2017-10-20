<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>p2p网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="${ctx}/static/css/common.css" rel="stylesheet" />
<link href="${ctx}/static/css/register.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/script/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/script/common.js"></script>
<script src="${ctx}/static/script/login.js" type="text/javascript"></script>
</head>
<body>
	<!-- 页面头部 -->
	<jsp:include page="/top.jsp">
	    <jsp:param value="title" name="apply"/>
	</jsp:include>
    <!--注册-->
	<div class="wrap">
    <form:form id="LonginForm" name="LonginForm" action="${ctx }/client/apply" method="post" modelAttribute="clientApply">
	    <div class="tdbModule loginPage">
	        <div class="registerTitle">借款申请</div>
	        <div class="registerCont">
	            <ul>
	                <li>
	                    <span class="dis">真实姓名：</span>
	                    <form:input  path="applyName" class="input" onblur="applyName()"   maxlength="24" tabindex="1" autocomplete="off" placeholder="请输入真实姓名"/>
	                </li>
	                <li>
	                    <span class="dis">联系电话：</span>
	                    <form:input class="input" path="applyCall" onblur="userNameJy()"   maxlength="24" tabindex="1" autocomplete="off" placeholder="请输入联系电话"/>
	                </li>
	                <li>
	                    <span class="dis">借款金额：</span>
	                   <form:input class="input" path="applyMoney" onblur="userNameJy()"   maxlength="24" tabindex="1" autocomplete="off" placeholder="请输入借款金额"/>
	                </li>
	                <li>
	                    <span class="dis">借款期限：</span>
	                    <form:input class="input" path="applyDeadline" onblur="userNameJy()"   maxlength="24" tabindex="1" autocomplete="off" placeholder="请输入借款期限"/>
	                </li>
	                <li>
	                    <span class="dis">所在地区：</span>
	                    <form:input class="input" path="applyLocation" onblur="userNameJy()"  maxlength="24" tabindex="1" autocomplete="off" placeholder="请输入所在地区"/>
	                </li>
	                <li>
	                  <span class="dis">验证码：</span><input type="text" onkeyup="verify(this)" id="jpgVerify" style="width:166px;" class="input" name="yzm" data-msg="验证码" maxlength="4" tabindex="1" autocomplete="off">
	                        <img src="images/code.jpg" id="yanzheng" alt="点击更换验证码" title="点击更换验证码" style="cursor:pointer;" class="valign">
	                    <a href="javascript:void(0);" onclick="changge();" class="blue">看不清？换一张</a>
	                </li>
	                <li class="btn"> 
	                    <input type="submit" class="radius1" value="立即申请" id="submitBtn"  >
	                </li>
	            </ul>
	        </div>
	    </div>
	    </form:form>
	</div>
    <!--网站底部-->
    <%@include file="/foot.jsp" %>
</body>
</html>