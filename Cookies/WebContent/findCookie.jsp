<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie c : cookies){
		String name = c.getName();
		String value = c.getValue();
		out.println("<h3>Name:" + name + " Value:" + value + "</h3>");
	}
}else{
	out.print("没有Cookie");
}
%>
<body>

</body>
</html>