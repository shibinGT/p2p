<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="page-content">
		<div class="page-header">
			<h1>添加角色</h1>
		</div>
		<!-- /.page-header -->

		<div class="row">
			<div class="col-xs-12">
				<form class="form-horizontal" role="form" action="${ctx }/role/add" method="post">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1"> 角色编号 </label>
						<div class="col-sm-9">
							<input type="text" id="form-field-2" placeholder="编号" name="roleCode"
								class="col-xs-10 col-sm-5" value="${role.roleCode }">

						</div>
					</div>

					<div class="space-4"></div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-2" > 描述 </label>

						<div class="col-sm-9">
							<input type="text" id="form-field-2" placeholder="描述" name="roleDesc"
								class="col-xs-10 col-sm-5" value="${role.roleDesc }">

						</div>
					</div>
					<!-- 权限列表 -->
					<div>
						<c:forEach items="${auths }" var="auth" varStatus="stat">
							<c:if test="${auth.authType==1 }">
							<input type="checkbox" name="auths" value="${auth.id }">${auth.authDesc }&nbsp;&nbsp;&nbsp;
							</c:if>
						</c:forEach>
					</div>

					<div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
							<button  type="submit">
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