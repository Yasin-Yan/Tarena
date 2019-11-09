package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setCookie")
public class AddCookieServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
//		´´½¨Cookie
		Cookie c1 = new Cookie("uname", "Kitty");
		Cookie c2 = new Cookie("city", "Beijing");
		response.addCookie(c1);
		response.addCookie(c2);
		out.close();
	}
}
