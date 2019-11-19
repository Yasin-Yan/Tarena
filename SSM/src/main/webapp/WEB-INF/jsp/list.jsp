<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
	<meta charset="UTF-8">
	<title>list</title>
</head>
<body>
<table>
	<c:forEach items="${list }" var="book" varStatus="index">
		<tr>
			<td>${book.bookId }</td>
			<td>${book.name }</td>
			<td>${book.number }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>