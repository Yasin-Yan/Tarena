<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 使用EL表达式进行运算 -->
<!-- 1.算数运算 -->
加：${1 + 2}<br>
加：${"123" + "456"}<br/><hr/>
<!-- 加号只能进行加法运算，不能连接 -->

<!-- 2.关系运算 -->
${"123" == "123"}<br/>
${"123" eq "123"}<br/>
<%pageContext.setAttribute("str", "abc");%>
${"abc" eq str}<br><hr>

<!-- 3.empty运算 -->
<%
	request.setAttribute("str1", "");
	List list = new ArrayList();
	request.setAttribute("list1", list);
	request.setAttribute("obj", null);
%>
空白字符串：${empty str1 }<br/>
找不到绑定对象：${empty xxx }<br/>
集合内容为空：${empty list1 }<br/>
null的结果：${empty obj }
</body>
</html>