<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		var name = $("#name").val();
		var pwd = $("#pwd").val();
		var params = {
				"name" : name,
				"pwd" : pwd
				};
// 		console.log(params);
// 		console.log(name + " " + pwd);
		$.post("post.do", params, function(data){
			console.log(data);
			$("#show").html("<p style='color: red;'>"+data+"</p>");
		}, "text");
	});
});
</script>
</head>
<body>
<input type="text" id="name">
<input type="text" id="pwd">
<input type="button" id="btn" value="Click">
<div id="show"></div>
</body>
</html>