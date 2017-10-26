<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/base.jsp"%>
<%@ include file="/top.jsp"%>
<%@ include file="/left-beforepage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- UEditor js -->
<script type="text/javascript" charset="utf-8"
	src="${ctx }/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${ctx }/utf8-jsp/ueditor.all.min.js">	
</script>
<script type="text/javascript" charset="utf-8"
	src="${ctx }/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="main-content">
		<div class="breadcrumbs" id="breadcrumbs">			
			<ul class="breadcrumb">
				<li><i class="icon-home home-icon"></i> <a href="${ctx}/main">首页</a></li>
				<li class="active">公告管理</li>
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

	<div>
	<form action="${ctx }/news/addNews" method="post" >
		<h1>新闻公告编辑</h1>
		模块名称:  <input type="text" name="newsModuleName"/>
				输入标题:<input type="text" name="newsTitle"/>
		<script id="editor" type="text/plain"
			style="width:1024px;height:500px;"></script>
			<button type="submit" class="btn btn-primary btn-sm">添加新闻</button>
	</form>
	</div>
	<button onclick="getContent()">获得内容</button>
	</div>
	<script type="text/javascript">
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('editor');		
		    function getContentTxt() {
		        var arr = [];
		        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
		        arr.push("编辑器的纯文本内容为：");
		        arr.push(UE.getEditor('editor').getContentTxt());
		        alert(arr.join("\n"));
		    }
		    function getContent() {
		        var arr = [];
		        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
		        arr.push("内容为：");
		        arr.push(UE.getEditor('editor').getContent());
		        alert(arr.join("\n"));
		    }
	</script>

</body>
</html>