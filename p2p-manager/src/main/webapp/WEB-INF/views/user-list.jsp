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
								<form class="form-group" action="${ctx }/user/list">
									<div class="input-group">
										<input name="employeeAccountNumber" placeholder="账号" class="form-control"
											value="${employee.employeeAccountNumber }"> 
											<input name="order" class="hidden" id="order" value="${order}"/>
											<span class="input-group-btn">
											<button class="btn btn-primary btn-sm" type="submit" id="searchForm">查询</button>
										</span>
									</div>
								</form>
							</div>
							<shiro:hasPermission name="admin:*">
							<div class="col-sm-2">
								<a href="${ctx }/user/toAddAdmin" class="btn btn-primary btn-sm"
									role="button">新增员工</a>
								
							</div>
							<div class="col-sm-1">
							
							<input type="button" class="btn btn-primary btn-sm"
                                    role="button" value="批量删除" id="delRole"> 
                               
                            </div>
                            
                            <div class="batchAddUser">
                            	<form action="${ctx }/file/batchAdd" enctype="multipart/form-data" method="post">
                            		<input type="file" name="batchAddEmployee"/><button type="submit">批量上传</button>
                            	</form>
                            </div>
							</shiro:hasPermission>
						</div>
						<form action="${ctx }/user/batchDel" method="post" id="delRoleForm">
						<table id="sample-table-2"
							class="table table-striped table-bordered table-hover dataTable"
							aria-describedby="sample-table-2_info">
							<thead>
								<tr role="row">
									<th class="center sorting_disabled" role="columnheader"
										rowspan="1" colspan="1" aria-label="" style="width: 96px;"><label>
									<input type="checkbox"  class="ace"  id="choose_role" > <span class="lbl"></span>
									</label></th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Domain: activate to sort column ascending"
										style="width: 258px;" onclick="order('employee_account_number')">账号</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Price: activate to sort column ascending"
										style="width: 179px;" onclick="order('employee_real_name')">真实姓名</th>
									<th class="sorting" role="columnheader" tabindex="0"
										aria-controls="sample-table-2" rowspan="1" colspan="1"
										aria-label="Price: activate to sort column ascending"
										style="width: 179px;" onclick="order('employee_phone')">电话号码</th>
										

									<th class="sorting_disabled" role="columnheader" rowspan="1"
										colspan="1" aria-label="" style="width: 266px;">操作</th>
								</tr>
							</thead>

							<tbody role="alert" aria-live="polite" aria-relevant="all" id="role_content">

								<c:forEach items="${pageInfo.list }" var="user">



									<tr class="odd">
										<td class="center  sorting_1"><label> <input
										
												type="checkbox" class="ace" name="lists" value="${user.employeeId }"> <span class="lbl"></span>
												
										</label></td>

										<td class=" ">${user.employeeAccountNumber }</td>
										<td class=" ">${user.employeeRealName }</td>
										<td class=" ">${user.employeePhone }</td>



										<td class=" ">
											<div
												class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
												<a class="blue" href="#"> <i
													class="icon-zoom-in bigger-130"></i>
												</a>
												<shiro:hasPermission name="user:*">
													<a class="green" href="${ctx }/user/update/${user.employeeId}/${user.employeeAccountNumber}"> <i
														class="icon-exchange bigger-130" title="重置密码为：123456"></i>
													</a>
													<a class="red" href="${ctx }/user/del/${user.employeeId}"> <i
														class="icon-trash bigger-130"></i>
													</a>
												</shiro:hasPermission>
											</div>


										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</form>
					</div>
					<page:pager url="${ctx }/user/list" pageInfo="${pageInfo }" />

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
	
	<script type="text/javascript">
//		批量删除
	$("#choose_role").click(function(){
        var checked = this.checked;
        $("#role_content input:checkbox").prop("checked",checked);
    })
    
    $("#delRole").click(function(){
    if($("#role_content input:checked").length==0){
        alert("请至少选中一条数据!");
        return;
    }
    if(confirm("确定要删除吗?")){
        $("#delRoleForm").submit();
        }
    })
	</script>


</body>
<%@ include file="/left-afterpage.jsp"%>
<%@ include file="/bottom.jsp"%>
</html>

