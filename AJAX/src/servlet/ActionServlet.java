package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Stock;
import net.sf.json.JSONArray;

@WebServlet(urlPatterns = {"/salary.do", "/quoto.do", "/post.do"})
public class ActionServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if("/salary".equals(action)) {
			String eId = request.getParameter("eId");
			if("T10001".equals(eId))
				out.println("实际工资：10000<br>个税：2500");
			else out.println("实际工资：20000<br>个税：5000");
		}else if("/quoto".equals(action)) {
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
			out.println(jsonStr);
		}else if("/post".equals(action)) {
			System.out.println("hello...");
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			out.println("name: "+name+" password: "+pwd);
		}
		out.close();
	}
}
