<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="el.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 访问Bean属性 -->
<%
	Course course = new Course();
	course.setCourseId(1);
	course.setCourseName("Servlet");
	User u1 = new User();
	u1.setName("Luffy");
	u1.setAge(17);
	u1.setCourse(course);
	u1.setInterest(new String[]{"Sleeping", "Eating"});
	request.setAttribute("user", u1);
%>
<!-- java代码 -->
1.Java代码<hr/>
<%
	User u = (User)request.getAttribute("user");
	out.println(u.getName());
	out.println(u.getAge());
%><br/><br/>
<!-- EL表达式 -->
2.EL表达式<br/>
<!-- 常用类型 -->
姓名：${requestScope.user.name}<br/>
年龄：${user.age}<br/>
<!-- 引用类型 -->
课程名:${user.course.courseName}<br/>
3.EL表达式2<br/>
姓名：${user["name"]}
年龄：${user["age"]}
爱好：${user.interest[1]}
</body>
</html>