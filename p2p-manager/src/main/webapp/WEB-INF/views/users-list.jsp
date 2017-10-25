<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ include file="/top.jsp"%>
<%@ include file="/left-beforepage.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>用户管理</title>
<meta name="keywords" content="后台管理" />
<meta name="description" content="后台管理" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<style type="text/css">
.excelUser{
	position: absolute;
    float: right;
    right: 260px;
    width: 270px;
    top: 5px;
    z-index: 9000;
}
</style>
</head>
<body>
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li><i class="icon-home home-icon"></i> <a href="${ctx}/main">首页</a></li>
				<li class="active">用户管理</li>
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

		<div class="page-content">
			<div class="col-xs-12">
				<div class="table-responsive">
					<div id="sample-table-2_wrapper" class="dataTables_wrapper"
						role="grid">
						<div class="row">
							<div class="col-sm-3">
								<form class="form-group" action="${ctx }/users/list">
									<div class="input-group">
										<input name="userName" placeholder="用户名" class="form-control"
											value="${user.userName }"> 
											<input name="order" class="hidden" id="order" value="${order}"/>
											<span class="input-group-btn">
											<button class="btn btn-primary btn-sm" type="submit" id="searchForm">查询</button>
										</span>
									</div>
								</form>
							</div>
							<shiro:hasPermission name="admin:*">
                            
                            <div class="batchAddUser">
                            	<form action="${ctx }/file/batchAddUser" enctype="multipart/form-data" method="post">
                            		<input type="file" name="batchAddEmployee"/><button type="submit">批量上传</button>
                            	</form>
                            </div>
							</shiro:hasPermission>
						</div>
						<table id="sample-table-2"
							class="table table-striped table-bordered table-hover dataTable"
							aria-describedby="sample-table-2_info">
							<thead>
								<tr role="row">
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Domain: activate to sort column ascending"
										style="width: 258px;" onclick="order('user_name')">用户名</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Price: activate to sort column ascending"
										style="width: 179px;" onclick="order('user_real_name')">真实姓名</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Price: activate to sort column ascending"
										style="width: 179px;" onclick="order('user_email')">邮箱</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Price: activate to sort column ascending"
										style="width: 179px;" onclick="order('user_idcard')">身份证</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Price: activate to sort column ascending"
										style="width: 179px;" onclick="order('user_phone')">电话</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Price: activate to sort column ascending"
										style="width: 179px;" onclick="order('user_registtime')">用户登录时间</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Price: activate to sort column ascending"
										style="width: 179px;" onclick="order('user_status')">状态</th>
										

									<th class="sorting_disabled" role="columnheader" rowspan="1"
										colspan="1" aria-label="" style="width: 266px;">解冻/冻结</th>
								</tr>
							</thead>

							<tbody role="alert" aria-live="polite" aria-relevant="all" id="role_content">

								<c:forEach items="${pageInfo.list }" var="user">



									<tr class="odd">
										<td class=" ">${user.userName }</td>
										<td class=" ">${user.userRealName }</td>
										<td class=" ">${user.userEmail }</td>
										<td class=" ">${user.userIdCard }</td>
										<td class=" ">${user.userPhone }</td>
										<td class=" ">${user.userRegisttime }</td>
										<td class=" ">
										<c:if test="${user.userStatus == 0 }">正常</c:if>
										<c:if test="${user.userStatus == 1 }">冻结</c:if>
										</td>



										<td class=" ">
											<div
												class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
												<shiro:hasPermission name="user:*">
													<a class="green"
													<c:if test="${user.userStatus == 0 }">
													 href="${ctx }/users/freeze/${user.userId}/1" 
													</c:if>
													<c:if test="${user.userStatus == 1 }">
													 href="javaScript:void(0);"
													</c:if>
													 > <i
														class="icon-exchange bigger-130" title="冻结用户"></i>
													</a>
													<a class="red"
													<c:if test="${user.userStatus == 0 }">
													href="javaScript:void(0);"
													</c:if>
													<c:if test="${user.userStatus == 1 }">
													  href="${ctx }/users/freeze/${user.userId}/0"
													</c:if>
													 ><i
														class="icon-trash bigger-130" title="解冻用户"></i>
													</a>
												</shiro:hasPermission>
											</div>


										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<page:pager url="${ctx }/users/list" pageInfo="${pageInfo }" />

				</div>
			</div>



		</div>

	<!-- /.main-content -->


	<script src="${ctx}/static/assets/js/typeahead-bs2.min.js"></script>


	<script src="${ctx}/static/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="${ctx}/static/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="${ctx}/static/assets/js/jquery.slimscroll.min.js"></script>
	<script src="${ctx}/static/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="${ctx}/static/assets/js/jquery.sparkline.min.js"></script>
	<script src="${ctx}/static/assets/js/flot/jquery.flot.min.js"></script>
	<script src="${ctx}/static/assets/js/flot/jquery.flot.pie.min.js"></script>
	<script src="${ctx}/static/assets/js/flot/jquery.flot.resize.min.js"></script>
	
	<script type="text/javascript">
		function order(order){
			$("#order").val(order);
			$("#searchForm").click();
		}
	
	</script>
	

</body>
<%@ include file="/left-afterpage.jsp"%>
<%@ include file="/bottom.jsp"%>
</html>

