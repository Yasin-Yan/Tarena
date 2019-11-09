<%@page import="bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入 Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="css/bootstrap-grid.min.css" rel="stylesheet"> -->
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="js/jquery-3.3.1.min.js"></script>
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="js/popper.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>
<title>修改员工信息</title>
</head>
<body>
<%
Employee emp = (Employee)request.getAttribute("emp");
%>
<div class="container">
	<div class="row">
		<div class="col-lg-4 offset-lg-5">
			<form action="modifyemp.do" method="post">
				<input type="hidden" value="<%=emp.getId()%>" name="id">
				<div class="form-group">
					<label for="name">姓名</label>
					<input type="text" id="name" name="name" class="form-control" value="<%=emp.getName() %>">
				</div>
				<div class="form-group">
					<label for="salary">薪水</label>
					<input type="text" id="salary" name="salary" class="form-control" value="<%=emp.getSalary() %>">
				</div>
				<div class="form-group">
					<label for="age">年龄</label>
					<input type="text" id="age" name="age" class="form-control" value="<%=emp.getAge() %>">
				</div>
				<input type="submit" class="btn btn-info" value="提交">
			</form>			
		</div>
	</div>
</div>
</body>
</html>