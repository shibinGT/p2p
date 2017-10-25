<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新</title>
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<h3>更新分组</h3>
		</div>
		<!-- /.page-header -->

		<div class="row">
			<div class="col-xs-12">
				<form class="form-horizontal" group="form"
					action="${ctx }/group/update" method="post">
					<div class="form-group">
						<input id="form-field-2" type="hidden" name="groupId"
							value="${group.groupId }" class="col-xs-10 col-sm-5">
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> 分组编码 </label>
						<div class="col-sm-9">
							<input type="text" id="form-field-2" placeholder="编号"
								name="groupCode" class="col-xs-10 col-sm-5"
								value="${group.groupCode }">
						</div>
					</div>
					<div class="space-4"></div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-2"> 描述 </label>

						<div class="col-sm-9">
							<input type="text" id="form-field-2" placeholder="描述"
								name="groupDesc" class="col-xs-10 col-sm-5"
								value="${group.groupDesc }">

						</div>
					</div>
					<div>
					角色列表：
					<c:forEach items="${roles }" var="role">
						<input type="checkbox" name="roleIds" value="${role.roleId }" 
							<c:forEach items="${group.roleIds }" var="roleId">
					       		<c:if test="${role.roleId == roleId }">checked="checked"</c:if>
					       </c:forEach>
						>${role.roleDesc }&nbsp; &nbsp; &nbsp;
					       
					</c:forEach>
					</div>
					<div>
					用户列表：
					<c:forEach items="${users }" var="user">
						<input type="checkbox" name="userIds" value="${user.employeeId }"
							<c:forEach items="${group.userIds }" var="userId">
					       		<c:if test="${user.employeeId == userId }">checked="checked"</c:if>
					       </c:forEach>
						>${user.employeeAccountNumber }&nbsp; &nbsp; &nbsp;
					</c:forEach>
					</div>
					<div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
							<button class="btn" type="submit">
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
</html>