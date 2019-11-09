<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.s1{
	cursor:pointer;
	position:relative;
	top:12px;
}
</style>
</head>
<body>
<h3>登录</h3>
<form action="login.do" method="POST">
	用户名：<input name="uname"/><br/>
	密    码：<input name="pwd"/><br/>
	验证码：<input name="vcode"/>
	<img src="code" onclick="this.src='code?'+Math.random();" class="s1" title="点击更换"/><br/>
	<input type="submit" value="登录"/>
</form>
</body>
</html>