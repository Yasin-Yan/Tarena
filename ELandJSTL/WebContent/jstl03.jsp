<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jstl.Employee, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.s1{color:red;}
	.s2{color:purple;}
</style>
</head>
<body>
<%
	Employee emp1 = new Employee();
	emp1.setName("Luffy");
	emp1.setGender("m");
	request.setAttribute("emp1", emp1);
	Employee emp2 = new Employee();
	emp2.setName("Zoro");
	emp2.setGender("m");
	request.setAttribute("emp2", emp2);
	List<Employee> emps = new ArrayList<Employee>();
	emps.add(emp1);
	emps.add(emp2);
	request.setAttribute("emps", emps);
%>
forEach标签1：<br/>
<c:forEach var="emp" items="${emps}" varStatus="s">
	姓名：${emp.name }&nbsp;&nbsp;
	性别：${emp.gender }&nbsp;&nbsp;
	count:${s.count }&nbsp;&nbsp;
	index:${s.index }<br/>
</c:forEach>
<br/>
forEach标签2：<hr/>
<c:forEach var="emp" items="${emps }" varStatus="s">
	<p class="s${s.index%2 + 1 }">
		姓名：${emp.name }&nbsp;&nbsp;
		性别：${emp.gender }&nbsp;&nbsp;
		count：${s.count }&nbsp;&nbsp;
		index：${s.index }
	</p>
</c:forEach>
</body>
</html>