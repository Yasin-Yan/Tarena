<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
// session验证
Object uname = session.getAttribute("uname");
if(uname == null){
	response.sendRedirect("login.jsp");
	return;
}
%>
<body>
<h3>首页</h3>欢迎你：<%=uname.toString() %><br>
<a href="logout.do">登出</a>
</body>
</html>