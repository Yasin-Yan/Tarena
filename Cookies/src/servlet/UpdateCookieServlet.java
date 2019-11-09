package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateCookie")
public class UpdateCookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Cookie[] cookies = request.getCookies();
		PrintWriter out = response.getWriter();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if(name.equals("city")) {
					cookie.setValue("ShangHai");
					response.addCookie(cookie);
				}
			}
		}
		out.close();
	}
}
