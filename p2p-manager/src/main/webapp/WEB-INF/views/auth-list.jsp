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
<script type="text/javascript" src="${ctx }/static/js/auth-add.js"></script>
<title>Insert title here</title>
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
				<li class="active">权限管理</li>
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
								<form class="form-group" action="${ctx }/auth/list"
									method="post">
									<div class="input-group">
										<input name="authCode" placeholder="权限名" class="form-control col-xs-10 col-sm-5"
											value="${auth.authCode }"/> 
											<input name="order" class="hidden" id="order" value="${order}"/>
											 <span
											class="input-group-btn">
											<button id="searchForm" class="btn btn-primary btn-sm" type="submit">查询</button>
										</span>

									</div>
								</form>
								<!-- 添加按钮触发添加模态框 -->
								<button class="btn btn-primary btn-sm" data-toggle="modal"
									data-target="#addModal">添加权限</button>
								<!-- 批量删除按扭 -->
								<button class="btn btn-primary btn-sm" onclick="batchDelAuth()">批量删除</button>
								<!-- 添加模态框（Modal） -->
								<div class="modal fade row" id="addModal" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<h4 class="modal-title" id="myModalLabel">添加权限</h4>
											</div>
											<div class="modal-body">
												<form action="${ctx }/auth/addAuth" class="form-horizontal"
													method="post" id="auth-addForm">
													<!-- 权限名 -->
													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-1"> 权限名 </label>
														<div class="col-sm-9">

															<input name="authCode" id="addauthCode"
																placeholder="" class="col-xs-10 col-sm-5" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-2"> 权限描述 </label>
														<div class="col-sm-9">
															<input name="authDesc" id="addauthDesc"
																placeholder="文字描述" class="col-xs-10 col-sm-5" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-3">防问资源</label>
														<div class="col-sm-9">
															<input name="authResource" id="addresource"
																placeholder="资源url" class="col-xs-10 col-sm-5" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-3 control-label no-padding-right"
															for="form-field-4"> 权限排序</label>
														<div class="col-sm-9">
															<input name="authSort" id="addsort" placeholder="number"
																class="col-xs-10 col-sm-5" />
														</div>
													</div>
													<!-- 下拉 -->
													<div class="form-group">
														<label for="form-field-select-1"
															class="col-sm-3 control-label no-padding-right">权限类型</label>
														<div class="col-sm-9">
															<select name="authType"
																class="form-control col-xs-10 col-sm-5" id="addauthType">
																<option value="0"
																	<c:if test="${auth.authType==0 }">selected="selected"</c:if>>系统</option>
																<option value="1"
																	<c:if test="${auth.authType==1 }">selected="selected"</c:if>>自定义</option>
															</select>
														</div>
													</div>
													<!-- 操作 -->
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
														<button type="submit" class="btn btn-primary">添加</button>
													</div>
												</form>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal -->
								</div>
							</div>
						</div>
						<form action="${ ctx}/auth/batchDelAuths" id="batchDelAuths"
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
											style="width: 258px;" onclick="order('auth_code')">权限名</th>
										<th class="sorting" role="columnheader" tabindex="0"
											aria-controls="sample-table-2" rowspan="1" colspan="1"
											aria-label="Price: activate to sort column ascending"
											style="width: 179px;" onclick="order('auth_desc')">权限描述</th>
										<th class="sorting" role="columnheader" tabindex="0"
											aria-controls="sample-table-2" rowspan="1" colspan="1"
											aria-label="Price: activate to sort column ascending"
											style="width: 179px;" onclick="order('auth_resource')">资源</th>
										<th class="sorting" role="columnheader" tabindex="0"
											aria-controls="sample-table-2" rowspan="1" colspan="1"
											aria-label="Price: activate to sort column ascending"
											style="width: 179px;" onclick="order('auth_sort')">排序</th>
										<th class="sorting" role="columnheader" tabindex="0"
											aria-controls="sample-table-2" rowspan="1" colspan="1"
											aria-label="Price: activate to sort column ascending"
											style="width: 179px;" onclick="order('auth_type')">类型</th>


										<th class="sorting_disabled" role="columnheader" rowspan="1"
											colspan="1" aria-label="" style="width: 266px;">操作</th>
									</tr>
								</thead>

								<tbody role="alert" aria-live="polite" aria-relevant="all"
									id="auth-content">

									<c:forEach items="${pageInfo.list }" var="auth">



										<tr class="odd">
											<td class="center  sorting_1"><label> <input
													type="checkbox" name="ids" class="ace" value="${auth.authId }">
													<span class="lbl"></span>
											</label></td>
											<td class=" " id="${auth.authId }1">${auth.authCode }</td>
											<td class=" " id="${auth.authId }2">${auth.authDesc }</td>
											<td class=" " id="${auth.authId }3">${auth.authResource }</td>
											<td class=" " id="${auth.authId }4">${auth.authSort }</td>
											<td class=" " id="${auth.authId }5">${auth.authType==0?"系统":"自定义" }</td>



											<td class=" ">
												<div
													class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
													<a class="blue" href="#"> <i
														class="icon-zoom-in bigger-130"></i>
													</a>
													<shiro:hasPermission name="user:*">
														<!-- 修改按钮-->
														<a class="green" href="javascript:void(0)"
															onclick="editInfo(${auth.authId})" data-toggle="modal"
															data-target="#updateModal"> <i
															class="icon-pencil bigger-130"></i>
														</a>


														<a class="red" href="javascript:void(0)"
															onclick="affirmDel(${auth.authId})"> <i
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

					<page:pager url="${ctx }/auth/list" pageInfo="${pageInfo }" />

				</div>
			</div>
			<!-- 修改模态框（Modal） -->
			<div class="modal fade row" id="updateModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">修改权限</h4>
						</div>
						<div class="modal-body">

							<form action="${ctx }/auth/updateAuth" class="form-horizontal"
								method="post" id="auth-updateForm">
								<!-- id -->

								<input name="authId" style="display: none;" id="id" value="" />
								<!-- 权限名 -->
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> 权限名 </label>
									<div class="col-sm-9">

										<input name="authCode" id="authCode"
											class="col-xs-10 col-sm-5" value="" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-2"> 权限描述 </label>
									<div class="col-sm-9">
										<input name="authDesc" id="authDesc" placeholder="文字描述"
											class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-3">防问资源</label>
									<div class="col-sm-9">
										<input name="authResource" id="resource" placeholder="资源url"
											class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-4"> 权限排序</label>
									<div class="col-sm-9">
										<input name="authSort" id="sort" placeholder="number"
											class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<!-- 下拉 -->
								<div class="form-group">
									<label for="form-field-select-1"
										class="col-sm-3 control-label no-padding-right">权限类型</label>
									<div class="col-sm-9">
										<select name="authType"
											class="form-control col-xs-10 col-sm-5" id="authType">
											<option value="0" id="option1">系统</option>
											<option value="1" id="option2">自定义</option>
										</select>
									</div>
								</div>
								<!-- 操作 -->
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
									<button class="btn btn-primary" onclick="affirmUpdate()">修改</button>
								</div>
							</form>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</div>
		</div>
		
		<script type="text/javascript">
			function order(order){
				$("#order").val(order);
				$("#searchForm").click();
			}
		
		</script>
		
		
		
		
		
		<script>
	
//触发修改模态框的同时调用此方法  
function editInfo(id) {  
   
    //获取表格中的一行数据  
    
    var AuthCode = $("#"+id+"1").text(); 
    var AuthDesc=$("#"+id+"2").text();
   	var Resource=$("#"+id+"3").text();
   	var Sort=$("#"+id+"4").text();
   	var AuthType=$("#"+id+"5").val;
   //赋值模态框
    $("#id").val(id);
   $("#authCode").val(AuthCode);  
    $("#authDesc").val(AuthDesc);  
    $("#resource").val(Resource);  
    $("#sort").val(Sort);  
 	$("#authType").val(AuthType);       
}   
	//确认删除
function affirmDel(id){
	if(confirm("确认删除？")){
	window.location.href=ctx+"/auth/delAuth/"+id;
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
			</script>
</body>
</html>