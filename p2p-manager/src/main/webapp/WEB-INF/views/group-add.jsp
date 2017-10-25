<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ include file="/top.jsp"%>
<%@ include file="/left-beforepage.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>分组管理</title>
<meta name="keywords" content="后台管理" />
<meta name="description" content="后台管理" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
				<li class="active">分组管理</li>
				<li>添加分组</li>
			</ul>
		</div>
		<div class="page-content">
		<div class="page-header">
			<h1>添加分组</h1>
		</div>
		<!-- /.page-header -->

		<div class="row">
			<div class="col-xs-12">
				<form class="form-horizontal" role="form" action="${ctx }/group/add" method="post" id="addgroupForm">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> 分组编码 </label>
						<div class="col-sm-9">
							<input type="text" id="inputCode" id="form-field-2" placeholder="分组编码（该组的名称）" name="groupCode"
								class="col-xs-10 col-sm-5" value="${group.groupCode }">
							<span id="codeErrors" style="display: inline;display:none; color:red;">不能为空</span>
						</div>
					</div>

					<div class="space-4"></div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-2" >分组描述 </label>

						<div class="col-sm-9">
							<input type="text" id="inputDesc" id="form-field-2" placeholder="描述" name="groupDesc"
								class="col-xs-10 col-sm-5" value="${group.groupDesc }">
							<span id="descErrors" style="display: inline; display:none;color:red;">不能为空</span>
						</div>
					</div>
					<!-- 用户列表 -->
					<div>
					用户列表：
						<c:forEach items="${users }" var="user" varStatus="stat">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="userIds" value="${user.employeeId}">${user.employeeAccountNumber }
						</c:forEach>
					</div>
					<!-- 角色列表 -->
					<div>
					角色列表：
						<c:forEach items="${roles2 }" var="role" varStatus="stat">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="roleIds" value="${role.roleId}">${role.roleDesc }
						</c:forEach>
					</div>

					<div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
							<button  type="submit" class="btn">
								<i class="icon-ok bigger-110"></i> Submit
							</button>

							&nbsp; &nbsp; &nbsp;
							<button class="btn" type="reset">
								<i class="icon-undo bigger-110"></i> Reset
							</button>
						</div>
					</div>
					</form>
			</div>
		</div>
	</div>
	
	
</body>
<script type="text/javascript" src="${ctx }/static/assets/js/addRole.js"></script>
<%@ include file="/left-afterpage.jsp"%>
<%@ include file="/bottom.jsp"%>
</html>

