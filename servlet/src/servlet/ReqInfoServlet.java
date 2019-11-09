package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReqInfoServlet
 */
@WebServlet("/ReqInfoServlet")
public class ReqInfoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有消息头的名称
		Enumeration e = request.getHeaderNames();
		while(e.hasMoreElements()) {
//			遍历Enumeration获取每一个消息头的名称
			String headerName = e.nextElement().toString();
//			输出消息头键值对
			System.out.println(headerName+":"+request.getHeader(headerName));
		}
		System.out.println("请求方式："+request.getMethod());
		System.out.println("请求的协议种类："+request.getProtocol());
		System.out.println("请求资源路径："+request.getRequestURI());
		System.out.println("请求路径信息："+request.getRequestURL());
		System.out.println("请求的Servlet路径："+request.getServletPath());
	}
}
