package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/login.do", "/logout.do"})
public class ActionServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UtF-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		HttpSession session = request.getSession();
		System.out.println(session.getId());
//		编程式--设定session超时时间为10秒
//		session.setMaxInactiveInterval(10);
//		判断动作是否为登录
		if("login".equals(action)) {
			String name = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			String number = request.getParameter("vcode");
			String code = session.getAttribute("code").toString();
			if(name.equals("111") && pwd.equals("111") && number.equals(code)) {
				session.setAttribute("uname", name);
//				重定向到首页
				response.sendRedirect("index.jsp");
//				response.sendRedirect(response.encodeRedirectURL("index.jsp"));
			}else {
//			登录失败
			request.setAttribute("msg", "用户名或密码错误");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
			request.getRequestDispatcher("validateCode.jsp").forward(request, response);
		}
	}else if(action.equals("logout")) {
//		session失效
		session.invalidate();
		response.sendRedirect("validateCode.jsp");
	}
		out.close();
  }
}
