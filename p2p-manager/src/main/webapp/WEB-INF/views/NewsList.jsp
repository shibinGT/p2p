<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/base.jsp"%>
<%@ include file="/top.jsp"%>
<%@ include file="/left-beforepage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 校验库 -->
<script type="text/javascript"
	src="${ctx }/static/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx }/static/js/messages_zh.js"></script>
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

		<!-- 以下正文 -->
		<div class="page-content">
			<div class="col-xs-12">
				<div class="table-responsive">
					<div id="sample-table-2_wrapper" class="dataTables_wrapper"
						role="grid">
						<div class="row">
							<div class="col-sm-3 ">
								<form class="form-group" action="${ctx }/news/queryNewsList"
									method="post">
									<div class="input-group">
										<input name="authCode" placeholder="" class="form-control col-xs-10 col-sm-5"
											value="${news.newsTitle }"/> 
											 <span
											class="input-group-btn">
											<button class="btn btn-primary btn-sm" type="submit">查询</button>
										</span>
									</div>
								</form>	
								<button class="btn btn-primary btn-sm" id="addNewsButton" >添加新闻公告</button>							
								</div>
							</div>
						</div>
						<form action="" id="batchDelAuths"
							method="post">
							<table id="sample-table-2"
								class="table table-striped table-bordered table-hover dataTable"
								aria-describedby="sample-table-2_info">
								<thead>
									<tr role="row">
										<th class="center sorting_disabled" role="columnheader"
											rowspan="1" colspan="1" aria-label="" style="width: 96px;"><label>
												<input type="checkbox" class="ace" id="checkAll"> <span
												class="lbl"></span>
										</label></th>
										<th class="sorting" role="columnheader" tabindex="0"
											aria-controls="sample-table-2" rowspan="1" colspan="1"
											aria-label="Domain: activate to sort column ascending"
											style="width: 258px;">模块名称</th>
										<th class="sorting" role="columnheader" tabindex="0"
											aria-controls="sample-table-2" rowspan="1" colspan="1"
											aria-label="Price: activate to sort column ascending"
											style="width: 179px;">新闻标题</th>
										<th class="sorting" role="columnheader" tabindex="0"
											aria-controls="sample-table-2" rowspan="1" colspan="1"
											aria-label="Price: activate to sort column ascending"
											style="width: 179px;">新闻内容</th>
										<th class="sorting" role="columnheader" tabindex="0"
											aria-controls="sample-table-2" rowspan="1" colspan="1"
											aria-label="Price: activate to sort column ascending"
											style="width: 179px;">新闻图片</th>
										<th class="sorting" role="columnheader" tabindex="0"
											aria-controls="sample-table-2" rowspan="1" colspan="1"
											aria-label="Price: activate to sort column ascending"
											style="width: 179px;">新闻发布时间</th>
										<th class="sorting" role="columnheader" tabindex="0"
											aria-controls="sample-table-2" rowspan="1" colspan="1"
											aria-label="Price: activate to sort column ascending"
											style="width: 179px;">新闻更新时间</th>
											<th class="sorting" role="columnheader" tabindex="0"
											aria-controls="sample-table-2" rowspan="1" colspan="1"
											aria-label="Price: activate to sort column ascending"
											style="width: 179px;">发布状态</th>
											<th class="sorting" role="columnheader" tabindex="0"
											aria-controls="sample-table-2" rowspan="1" colspan="1"
											aria-label="Price: activate to sort column ascending"
											style="width: 179px;">操作人ID</th>
											<th class="sorting" role="columnheader" tabindex="0"
											aria-controls="sample-table-2" rowspan="1" colspan="1"
											aria-label="Price: activate to sort column ascending"
											style="width: 179px;">最后修改时间</th>
										<th class="sorting_disabled" role="columnheader" rowspan="1"
											colspan="1" aria-label="" style="width: 266px;">操作</th>
									</tr>
								</thead>

								<tbody role="alert" aria-live="polite" aria-relevant="all"
									id="auth-content">

									<c:forEach items="${pageInfo.list }" var="news">
										<tr class="odd">
											<td class="center  sorting_1"><label> <input
													type="checkbox" name="ids" class="ace" value="${auth.id }">
													<span class="lbl"></span>
											</label></td>
											<td class=" " id="${news.newsId }1">${news.newsModuleName }</td>
											<td class=" " id="${news.newsId }2">${news.newsTitle }</td>
											<td class=" " id="${news.newsId }3">${news.newsContent }</td>
											<td class=" " id="${news.newsId }4">${news.newsImg }</td>																						
											<td class=" " id="${news.newsId }6"><fmt:formatDate value="${news.newsReleaseTime }" pattern="yyyy/MM/dd  HH:mm:ss"/></td>
											<td class=" " id="${news.newsId }7"><fmt:formatDate value="${news.newsUpdateTime }" pattern="yyyy/MM/dd  HH:mm:ss"/></td>
											<td class=" " id="${news.newsId }8">${news.newsReleaseStatus==0?"预览":news.newsReleaseStatus==1?"发布":"下架" }</td>
											<td class=" " id="${news.newsId }9">${news.newsEmployeeId }</td>
											<td class=" " id="${news.newsId }10"><fmt:formatDate value="${news.newsModificationTime }" pattern="yyyy/MM/dd HH:mm:ss"/></td>
											<td class=" ">
												<div
													class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
													<a class="blue" href="#"> <i
														class="icon-zoom-in bigger-130"></i>
													</a>
														<c:if test="${news.newsReleaseStatus==0}">
														<button id="" >发布</button>
														</c:if>
														<c:if test="${news.newsReleaseStatus==1}">
														<button id="" >下架</button>
														<c:if test="${news.newsReleaseStatus==2}">
														<button id="" >发布</button>
														</c:if>
														</c:if>
														<!-- 删除 -->
														<a class="red" href="javascript:void(0)"
															onclick="affirmDel(${news.newsId})"> <i
															class="icon-trash bigger-130"></i>
														</a>													
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</form>
					</div>

					<page:pager url="${ctx }/news/list" pageInfo="${pageInfo }" />

				</div>
			</div>		
		</div>
		
		
<script>
	//确认删除
function affirmDel(id){
	if(confirm("确认删除？")){
	window.location.href=ctx+"/news/delNews/"+id;
	}
}
//确认修改
function affirmUpdate(){
	if(confirm("确认修改？")){
	$("#auth-updateForm").submit();
	}
}
//全选功能
	$("#checkAll").click(function(){
		//列表按扭的checked属性与头checkAll的checked属性保持一致
		 $("input[name='ids']").prop("checked",$(this).prop("checked"));
	});
//批量删除
function batchDelAuth(){
	if($("#auth-content input:checked").length==0){
		alert("请至少选择一条权限");
		return;
	}else {
		if(confirm("你确定要删除吗?")){
			$("#batchDelAuths").submit();
	}
  }
}
//添加新闻按钮
$("#addNewsButton").click(function(){
	window.location.href=ctx+"/news/toAddNews";
});
</script>			
</body>
</html>