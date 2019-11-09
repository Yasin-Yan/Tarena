package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = {"/life.do"})
public class LifeServlet extends HttpServlet{

	//实例化
	public LifeServlet() {
		System.out.println("1.Constructor is running...");
	}
	
	//初始化
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("2.Init is running...");
	}
	
	//就绪
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletConfig config = getServletConfig();
		String name = config.getInitParameter("company");
		String address = config.getInitParameter("address");
		System.out.println("初始化参数为："+name+"   "+address);
	}
	
	//销毁
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("4.Destroy is running...");
	}
}
