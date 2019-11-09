<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<title>emps</title>
</head>
<body>
	<table  cellpadding="0" cellspacing="0" width="50%" border='1'>
		<tr>
			<td>员工号</td>
			<td>员工姓名</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>T10001</td>
			<td>张三</td>
			<td>
				<a href="javascript:;" class="s1">显示工资明细</a>
				<div></div>
			</td>
		</tr>
		<tr>
			<td>T10002</td>
			<td>李四</td>
			<td>
				<a href="javascript:;" class="s1">显示工资明细</a>
				<div></div>
			</td>
		</tr>
	</table>
</body>
<script>
	$(function(){
		$('.s1').click(function(){
			var eId = $(this).parent().siblings().eq(0).text();
			$(this).next().load('salary.do', 'eId=' + eId);
		});
	});
</script>
</html>