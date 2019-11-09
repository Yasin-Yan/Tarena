package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/encodeCookie")
public class EncodeCookieServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		先将中文进行UTF-8编码，再将编码后的字节数组转变为字符串
		String city = URLEncoder.encode("北京", "UTF-8");
//		创建Cookie
		Cookie c1 = new Cookie("uname", "Kitty");
		Cookie c2 = new Cookie("city", city);
		response.addCookie(c1);
		response.addCookie(c2);
	}
}
