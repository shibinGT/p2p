<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ include file="/top.jsp"%>
<%@ include file="/left-beforepage.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>角色管理</title>
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
				<li class="active">角色管理</li>
				<li>添加角色</li>
			</ul>
		</div>
		<div class="page-content">
		<div class="page-header">
			<h1>添加角色</h1>
		</div>
		<!-- /.page-header -->

		<div class="row">
			<div class="col-xs-12">
				<form class="form-horizontal" role="form" action="${ctx }/role/add" method="post" id="addRoleForm">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> 角色编号 </label>
						<div class="col-sm-9">
							<input type="text" id="inputCode" id="form-field-2" placeholder="编号" name="roleCode"
								class="col-xs-10 col-sm-5" value="${role.roleCode }">
							<span id="codeErrors" style="display: inline;display:none; color:red;">不能为空</span>
						</div>
					</div>

					<div class="space-4"></div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-2" > 描述 </label>

						<div class="col-sm-9">
							<input type="text" id="inputDesc" id="form-field-2" placeholder="描述" name="roleDesc"
								class="col-xs-10 col-sm-5" value="${role.roleDesc }">
							<span id="descErrors" style="display: inline; display:none;color:red;">不能为空</span>
						</div>
					</div>
					<!-- 权限列表 -->
					<div>
						<c:forEach items="${auths }" var="auth" varStatus="stat">
							<c:if test="${auth.authType==1 }">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="auths" value="${auth.authId }">${auth.authDesc }
							</c:if>
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

