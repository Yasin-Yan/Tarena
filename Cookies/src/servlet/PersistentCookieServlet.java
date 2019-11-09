package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/persistentCookie")
public class PersistentCookieServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		����Cookie
		Cookie c1 = new Cookie("uname", "Kitty");
//		����c1�Ĺ���ʱ��,��λΪ��
		c1.setMaxAge(100);
		response.addCookie(c1);
		Cookie c2 = new Cookie("city", "Beijing");
		response.addCookie(c2);
		out.close();
	}
}
