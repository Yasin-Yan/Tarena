<%@page import="bean.Employee"%>
<%@page import="java.util.List"%>
<%@page import="dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入 Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="css/bootstrap-grid.min.css" rel="stylesheet"> -->
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="js/jquery-3.3.1.min.js"></script>
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="js/popper.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>
<title>查询员工信息</title>
<style type="text/css">
td{
	text-align: center;
}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-lg-12" >
			<div class="row">
				<!-- <div class="col-lg-5" style="border: 1px solid black;"></div> -->
				<div class="col-lg-6 offset-lg-4" style="overflow-y: scroll;height: 700px;">
					<table class="table table-hover" >
						<p align="center"><strong>员工信息</strong></p>
						<thead>
							<tr>
								<td>#</td>
								<td>姓名</td>
								<td>薪水</td>
								<td>年龄</td>
								<td>操作</td>
							</tr>							
						</thead>
						<tbody>
							<%
							List<Employee> emps = (List<Employee>)request.getAttribute("emps");
							for(Employee emp : emps){	
							%>
							<tr>
								<td><%=emp.getId() %></td>
								<td><%=emp.getName() %></td>
								<td><%=emp.getSalary() %></td>
								<td><%=emp.getAge() %></td>
								<td>
									<a href="loademp.do?id=<%=emp.getId() %>" class="btn btn-primary btn-sm">修改</a>
									<a href="deleteemp.do?id=<%=emp.getId()%>" onclick="return confirm('是否确定删除<%=emp.getName()%>');" class="btn btn-danger btn-sm">删除</a>
								</td>
							</tr>
							<%} %>							
						</tbody>		
					</table>				
				</div>
				<div class="col-lg-6 offset-lg-4">
					<a href="addEmp.html" class="btn btn-success btn-sm">添加</a>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>