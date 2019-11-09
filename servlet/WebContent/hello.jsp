<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body style="font-size: 24px;">
<%--使用out.print("Hello JSP");方式输出 --%>
<%
	for(int i = 0; i < 10; i++)
		out.print("Hello JSP<br>");
%>
<hr>
<!-- 使用<%="Hello JSP"%>方式输出 -->
<%
	for(int i = 0; i < 10; i++){
%>
	<%="NO."+(i+1)+"Hello JSP"%><br>
<% } %>
</body>
</html>