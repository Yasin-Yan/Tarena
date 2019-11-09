<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入 Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="css/bootstrap-grid.min.css" rel="stylesheet"> -->
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="js/jquery-3.3.1.min.js"></script>
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="js/popper.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>
<title>页面出错</title>
</head>
<body>
<%
String error = (String)request.getAttribute("error");
%>
<div class="jumbotron">
	<div class="container">
		<h1 class="display-4">404 Not Found</h1>
		<p class="lead"><strong class="text-white bg-info"><%=error %></strong></p>
		<a href="listemp.do" class="btn btn-primary btn-lg" role="button"><strong>返回主页</strong></a>
	</div>
</div>
</body>
</html>