<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="page" uri="http://weborder.qhcs.com/tags/pager"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%-- <%
	String ctx = request.getServletContext().getContextPath();
	session.setAttribute("ctx", ctx);
%> --%>
<!DOCTYPE html>
<html>

<head>
<c:set value="${pageContext.request.contextPath}" var="ctx" scope="request"></c:set>
<script type="text/javascript">
    var ctx='${ctx}'
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--移动设备优先 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1,user-scalable=no">

<!--导入css 样式 --->
<link rel="stylesheet" href="${ctx}/static/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${ctx}/static/assets/css/font-awesome.min.css" />
<!--[if IE 7]>
          <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
        <![endif]-->
<!-- ace styles 左边菜单栏 ace 样式-->
<link rel="stylesheet" href="${ctx}/static/assets/css/ace.min.css" />
<link rel="stylesheet" href="${ctx}/static/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${ctx}/static/assets/css/ace-skins.min.css" />
<!--[if lte IE 8]>
          <link rel="stylesheet" href="${ctx}/static/assets/css/ace-ie.min.css" />
        <![endif]-->
<!--<link rel="stylesheet" href="css/bootstrap-theme.min.css" />-->


<!-- ace settings handler -->

<script src="${ctx}/static/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
        <script src="${ctx}/static/assets/js/html5shiv.js"></script>
        <script src="${ctx}/static/assets/js/respond.min.js"></script>
        <![endif]-->


<!--导入js文件, 必须先导入 jquery-->
<script type="text/javascript"
	src="${ctx}/static/assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/assets/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src='${ctx}/static/assets/js/jquery.mobile.custom.min.js'></script>
<!-- ace scripts 左边菜单栏 ace JS-->
<script src="${ctx}/static/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/static/assets/js/ace.min.js"></script>

</head>
<body>

</body>
</html>