<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctx=request.getContextPath();
	session.setAttribute("ctx", ctx);
%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${ctx}/static/css/common.css" rel="stylesheet" />
<link href="${ctx}/static/css/register.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/script/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/static/script/common.js"></script>
</head>
<body>
    <header>
        <div class="header-top min-width">
            <div class="container fn-clear">
                <strong class="fn-left">咨询热线：400-668-6698<span
                    class="s-time">服务时间：9:00 - 18:00</span></strong>
                <ul class="header_contact">
                    <li class="c_1"><a class="ico_head_weixin" id="wx"></a>
                        <div class="ceng" id="weixin_xlgz" style="display: none;">
                            <div class="cnr">
                                <img src="${ctx}/static/images/code.png">
                            </div>
                            <b class="ar_up ar_top"></b> <b class="ar_up_in ar_top_in"></b>
                        </div></li>
                    <li class="c_2"><a href="#" target="_blank" title="官方QQ"
                        alt="官方QQ"><b class="ico_head_QQ"></b></a></li>
                    <li class="c_4"><a href="#" target="_blank" title="新浪微博"
                        alt="新浪微博"><b class="ico_head_sina"></b></a></li>
                </ul>
                <ul class="fn-right header-top-ul">
                    <li><a href="index.html" class="app">返回首页</a></li>
                    <li>
                        <div class="">
                            <a href="${ctx }/toregister" class="c-orange" title="免费注册">免费注册</a>
                            
                        </div>
                    </li>
                    <c:if test="${empty loginUser.userName}">
                    <li>                                                  
                          	<div class="">
                           	 	<a href="${ctx }/tologin" class="js-login" title="登录">登录</a>                           
                     		   </div>                     
                    </li>
                    </c:if>
                    <c:if test="${not empty loginUser.userName}">
                    <li>                                                  
                          	<div class="">
                          	欢迎你 ${loginUser.userName}
                           	 	<button id="logoutbutton" onclick="location.href='${ctx }/logout'">安全退出</button>                         
                     		   </div>                     
                    </li>
                    </c:if>
                </ul>
            </div>
        </div>
        <div class="header min-width">
            <div class="container">
                <div class="fn-left logo">
                    <a class="" href="index.html"> <img src="${ctx}/static/images/logo.png"
                        title="">
                    </a>
                </div>
                <ul class="top-nav fn-clear">
                    <li class="on"><a href="${ctx}/index.jsp" class="${param.index }">首页</a></li>
                    <li><a href="${ctx}/investment/projectList" class="${param.investment}">我要投资</a></li>
                    <li><a href="${ctx }/client/toApply" class="${param.apply }">我要借款</a></li>
                    <li><a href="${ctx}/toSafety" class="${param.safety }">安全保障</a></li>
                    <li class="top-nav-safe"><a href="${ctx}/toPay" class="${param.account }">我的账户</a></li>
                    <li><a href="公司简介.html" class="${param.index0 }">关于我们</a></li>
                </ul>
            </div>
        </div>
    </header>
</body>

</html>