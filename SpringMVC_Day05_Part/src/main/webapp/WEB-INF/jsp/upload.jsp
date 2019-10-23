<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传图片</title>
</head>
<body>
	${errors}
	<form action="upload.do" method="POST" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit" value="submit">
	</form>
	<hr>
	<form action="uploads.do" method="POST" enctype="multipart/form-data">
		<input type="file" name="file"><br>	
		<input type="file" name="file">
		<input type="submit" value="submit">
	</form>
</body>
</html>