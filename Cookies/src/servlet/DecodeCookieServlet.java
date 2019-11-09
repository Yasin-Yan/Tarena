package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/decodeCookie")
public class DecodeCookieServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				out.print("<h3>Name:" + name + " Value:" + URLDecoder.decode(value, "UTF-8") + "</h3>");
			}
		}else {
			out.println("Ã»ÓÐcookie");
		}
		out.close();
	}
}
