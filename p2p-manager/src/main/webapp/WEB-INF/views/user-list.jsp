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
</head>
<body>
	<div class="main-content">
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
								<form class="form-group" action="${ctx }/user/list">
									<div class="input-group">
										<input name="name" placeholder="用户名" class="form-control"
											value="${user.employeeAccountNumber }"> <span class="input-group-btn">
											<button class="btn btn-primary btn-sm" type="submit">查询</button>
										</span>
									</div>
								</form>
							</div>
							<shiro:hasPermission name="admin:*">
							<div class="col-sm-2">
								<a href="${ctx }/user/toAddAdmin" class="btn btn-primary btn-sm"
									role="button">新增管理员</a>
							</div>
							</shiro:hasPermission>
						</div>
						<table id="sample-table-2"
							class="table table-striped table-bordered table-hover dataTable"
							aria-describedby="sample-table-2_info">
							<thead>
								<tr role="row">
									<th class="center sorting_disabled" role="columnheader"
										rowspan="1" colspan="1" aria-label="" style="width: 96px;"><label>
											<input type="checkbox" class="ace"> <span class="lbl"></span>
									</label></th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Domain: activate to sort column ascending"
										style="width: 258px;">姓名</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Price: activate to sort column ascending"
										style="width: 179px;">密码</th>


									<th class="sorting_disabled" role="columnheader" rowspan="1"
										colspan="1" aria-label="" style="width: 266px;">操作</th>
								</tr>
							</thead>

							<tbody role="alert" aria-live="polite" aria-relevant="all">

								<c:forEach items="${pageInfo.list }" var="user">



									<tr class="odd">
										<td class="center  sorting_1"><label> <input
												type="checkbox" class="ace"> <span class="lbl"></span>
										</label></td>

										<td class=" "><a href="#">${user.employeeAccountNumber }</a></td>
										<td class=" ">${user.employeePassword }</td>



										<td class=" ">
											<div
												class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
												<a class="blue" href="#"> <i
													class="icon-zoom-in bigger-130"></i>
												</a>
												<shiro:hasPermission name="user:*">
													<a class="green" href="#"> <i
														class="icon-pencil bigger-130"></i>
													</a>
													<a class="red" href="#"> <i
														class="icon-trash bigger-130"></i>
													</a>
												</shiro:hasPermission>
											</div>


										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<page:pager url="${ctx }/user/list" pageInfo="${pageInfo }" />

				</div>
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


</body>
<%@ include file="/left-afterpage.jsp"%>
<%@ include file="/bottom.jsp"%>
</html>

