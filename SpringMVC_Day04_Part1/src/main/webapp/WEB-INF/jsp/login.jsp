<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="base" value="/"></c:url>
<html lang="zh_CN">
<head>
	<meta charset="UTF-8">
	<title>Login Form</title>
	<link rel="stylesheet" type="text/css" href="${base}styles.css">
</head>
<body>
	<h6>${message}</h6>
	<form action="${base}login/login-action1.do">
		<div>
			<h2>登录login-action1.do</h2>
			<p>
				<lable>用户</lable><input type="text" name="name">
			</p>
			<p>
				<lable>密码</lable><input type="password" name="pwd">
			</p>
			<h3>
				<input type="submit" value="登录">
			</h3>
		</div>
	</form>
	<form action="${base}login/login-action2.do">
		<div>
			<h2>登录login-action2.do</h2>
			<p>
				<lable>用户</lable><input type="text" name="name">
			</p>
			<p>
				<lable>密码</lable><input type="password" name="pwd">
			</p>
			<h3>
				<input type="submit" value="登录">
			</h3>
		</div>
	</form>
	<form action="${base}login/login-action3.do">
		<div>
			<h2>登录login-action3.do</h2>
			<p>
				<lable>用户</lable><input type="text" name="name">
			</p>
			<p>
				<lable>密码</lable><input type="password" name="pwd">
			</p>
			<h3>
				<input type="submit" value="登录">
			</h3>
		</div>
	</form>
	<form action="${base}login/login-action4.do">
		<div>
			<h2>登录login-action4.do</h2>
			<p>
				<lable>用户</lable><input type="text" name="name">
			</p>
			<p>
				<lable>密码</lable><input type="password" name="pwd">
			</p>
			<h3>
				<input type="submit" value="登录">
			</h3>
		</div>
	</form>
	<form action="${base}login/login-action5.do">
		<div>
			<h2>登录login-action5.do</h2>
			<p>
				<lable>用户</lable><input type="text" name="name">
			</p>
			<p>
				<lable>密码</lable><input type="password" name="pwd">
			</p>
			<h3>
				<input type="submit" value="登录">
			</h3>
		</div>
	</form>
	<form action="${base}login/login-action6.do">
		<div>
			<h2>登录login-action6.do</h2>
			<p>${next}</p>
			<p>
				<lable>用户</lable><input type="text" name="name" value="${name }">
			</p>
			<p>
				<lable>密码</lable><input type="password" name="pwd">
			</p>
			<h3>
				<input type="submit" value="登录">
			</h3>
		</div>
	</form>
</body>
</html>