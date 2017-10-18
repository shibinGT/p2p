<%@page import="com.qhcs.ssm.entity.User"%>
<%@page import="com.github.pagehelper.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="/base.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
   <div class="container-fluid">
   
	<form action="${ctx }/user/list" class="form-group form-horizontal">
		<div class="form-group">
			<label class="col-md-1 text-right">用户名：</label><div class="col-md-4 text-left"><input name="lastName" class="form-control"></div>
			<label class="col-md-1 text-right">年龄：</label><div class="col-md-4 text-left"><input name="age" class="form-control"></div>
			 <div class="col-md-2 text-right">
		 		<input type="submit" class="btn btn-primary" value="查询">
		 	</div>
		 </div>
	</form>
	
   </div>
   <table class='table table-striped table-condensed table-hover table-bordered'>
	   		<tr>
	   			<th>姓名</th>
	   			<th>年龄</th>
	   			<th>出生年月</th>
	   		</tr>
	<c:if test="${pageInfo.list.size()==0 }">
		<tr>
			<td colspan="3">没有查询道任何数据...
			</td>
		</tr>
	</c:if>
	
	<c:forEach items="${pageInfo.list}" var="user">
	   <tr>
	   	  <td>
			${user.lastName }
		  </td>
		  <td>
		    ${user.age }
		  </td>
		  <td>
		 	 
		  </td>
		</tr>
	</c:forEach>
   </table>
	
	<%-- <page:pager pageSize="${pageInfo.pageSize }" pageNum="${pageInfo.pageNum}" url="${ctx }/user/list" recordCount="${pageInfo.total}"/> --%>
   ${pageInfo}
	<ul class="pagination">
		  <li><a href="">首页</a></li>
		 <li><a href="">上一页</a></li>
		 <c:forEach items="${pageInfo.navigatepageNums}" var="pageNo">
		 <li>	<a href=""> ${pageNo} </a></li>
		 </c:forEach> 
		<li><a href="">下一页</a></li>
	</ul>
</body>
</html>