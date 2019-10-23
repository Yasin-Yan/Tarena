<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.s1{color:red;}
	.s2{color:purple}
</style>
</head>
<body>
城市信息列表：<hr/>
<c:forEach var="city" items="${cities }" varStatus="s">
	<p class="s${s.index%2 + 1 }">
		编号：${city.id }&nbsp;&nbsp;
		城市：${city.name}
		<br/>
	</p>
</c:forEach>
</body>
</html>