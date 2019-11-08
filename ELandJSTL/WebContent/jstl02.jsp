<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="jstl.Employee" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Employee emp = new Employee();
	emp.setName("Luffy");
	emp.setGender("m");
	request.setAttribute("emp", emp);
%>
choose标签：<hr/>
员工性别：
<c:choose>
	<c:when test="${emp.gender == 'm' }">男</c:when>
	<c:otherwise>女</c:otherwise>
</c:choose>
</body>
</html>