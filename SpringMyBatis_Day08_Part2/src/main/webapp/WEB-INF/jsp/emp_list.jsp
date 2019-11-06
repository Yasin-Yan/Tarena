<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表示例</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>工资</td>
			<td>年龄</td>
		</tr>
		<c:forEach items="${emps }" var="emp">
			<tr>
				<td>${emp.id }</td>
				<td>${emp.name }</td>
				<td>${emp.salary }</td>
				<td>${emp.age }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>