<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jstl.Employee" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	if标签：<hr/>
	员工姓名：${emp.name }<br/>
	员工性别：<c:if test="${emp.gender == 'm' }" var="rs" scope="request">男</c:if>
	<c:if test="${!rs }">女</c:if>
</body>
</html>