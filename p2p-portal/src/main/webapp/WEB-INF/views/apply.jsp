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
<script type="text/javascript" src="${ctx}/static/script/apply.js"></script>
<script src="${ctx}/static/script/login.js" type="text/javascript"></script>
<script type="text/javascript">
    var ctx='${ctx}';
</script>
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
	                    <form:input  path="applyName" class="input" id="applyName"    maxlength="24" tabindex="1" autocomplete="off" placeholder="请输入真实姓名"/>
	                    <span id="name"></span>
	                </li>
	                <li>
	                    <span class="dis">联系电话：</span>
	                    <form:input class="input" path="applyCall" id="applyCall"    maxlength="24" tabindex="1" autocomplete="off" placeholder="请输入联系电话"/>
	                    <span id="call"></span>
	                </li>
	                <li>
	                    <span class="dis">借款金额：</span>
	                   <form:input class="input" path="applyMoney" id="applyMoney"    maxlength="24" tabindex="1" autocomplete="off" placeholder="请输入借款金额"/>
	                  元 <span id="money"></span>
	                </li>
	                <li>
	                    <span class="dis">借款期限：</span>
	                    <form:input class="input" path="applyDeadline" id="applyDeadline"    maxlength="24" tabindex="1" autocomplete="off" placeholder="请输入借款期限"/>
	                    天<span id="deadline"></span>
	                </li>
	                <li>
	                    <span class="dis">所在地区：</span>
	                    <form:input class="input" path="applyLocation" id="applyLocation"   maxlength="24" tabindex="1" autocomplete="off" placeholder="请输入所在地区"/>
	                   <span id="location"></span>
	                </li>
	                <li>
	                  <span class="dis">验证码：</span><input type="text"  id="code" style="width:166px;" class="input" name="code" data-msg="验证码" maxlength="4" tabindex="1" autocomplete="off" placeholder="请输入验证码">
	                        <a href="javascript:void(0);" id="changeCode"  class="blue">
	                        <img src=" ${ctx}/client/getCode" id="yanzheng" alt="点击更换验证码" title="点击更换验证码" style="cursor:pointer;" class="valign">
	                    看不清？换一张</a><span id="showCode" ></span>
	                </li>
	                <li class="btn"> 
	                    <input type="submit"  value="立即申请" id="submitBtn" disabled="disabled" >
	                </li>
	            </ul>
	        </div>
	    </div>
	    </form:form>
	</div>
    <!--网站底部-->
    <%@include file="/foot.jsp" %>
    <script type="text/javascript">
      var result = '${sessionScope.result}';
     if(result=='true'){
    	    alert("申请成功");
    	    result='false';
     }
    </script>
</body>
<%
session.removeAttribute("result");
%>
</html>