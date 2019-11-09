<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<title>stock</title>
<style type="text/css">
#d1{
	width: 450px;
	height: 280px;
	background-color: black;
	margin-left: 400px;
	margin-top: 50px;
}

#d2{
	color: white;
	background-color: purple;
	height: 35px;
}

table{
	color: white;
	font-size: 24px;
}
</style>
</head>
<body>
<div id="d1">
	<div id="d2">股票实时行情</div>
	<div id="d3">
		<table width="100%" cellpadding="0" cellspacing="0">
			<thead>
				<tr>
					<td>代码</td>
					<td>名称</td>
					<td>价格</td>
				</tr>
			</thead>
			<tbody id="tb1">
			</tbody>
		</table>
	</div>
</div>
</body>
<script>
	$(function(){
		setInterval(quoto, 2000);
	});

	function quoto(){
		$.post('quoto.do', function(data){
			$('#tb1').empty();
			$.each(data, function(index, info){
				$('#tb1').append('<tr><td>' + info.code + '</td><td>' + info.name + '</td><td>' + info.price + '</td></tr>');
			});
		}, 'json');
	}
</script>
</html>