<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<title>Insert title here</title>
</head>
<body>
name: <input type="text" value="name123" id="name"><br>
<button onclick="test()">Click</button>
</body>
<script type="text/javascript">
function test(){
	var name = $("#name").val();
	$.ajax({
		url: "/AJAX/response.jsp",
		type: "POST",
		dataType: "json",
		data: {
			"name": name
		},
		success: function(data){
//			var ans = data.split(" ");
//			console.log(ans[0]);
			console.log(data[0].code);
			console.log(data[0].name);
		},
		error: function(e){
			console.log("fail.....");
			console.log(e);
		}
	});
}
</script>
</html>