<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="bean.Stock"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Random"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
PrintWriter writer = response.getWriter();
String name = request.getParameter("name");
Random r = new Random();
List<Stock> stocks = new ArrayList<Stock>();
for (int i = 0; i < 8; i++) {
	Stock s = new Stock();
	s.setCode("60001" + r.nextInt(10));
	s.setName("中国国贸" + r.nextInt(10));
	DecimalFormat df = new DecimalFormat("0.00");
	double price = Double.parseDouble(df.format(100 * r.nextDouble()));
	s.setPrice(price);
	stocks.add(s);
}
JSONArray jsonArr = JSONArray.fromObject(stocks);
String jsonStr = jsonArr.toString();
System.out.println(jsonStr);
writer.println(jsonStr);
writer.close();
%>
<body>

</body>
</html>