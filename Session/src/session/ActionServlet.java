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
//		���ʽ--�趨session��ʱʱ��Ϊ10��
//		session.setMaxInactiveInterval(10);
//		�ж϶����Ƿ�Ϊ��¼
		if("login".equals(action)) {
			String name = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			String number = request.getParameter("vcode");
			String code = session.getAttribute("code").toString();
			if(name.equals("111") && pwd.equals("111") && number.equals(code)) {
				session.setAttribute("uname", name);
//				�ض�����ҳ
				response.sendRedirect("index.jsp");
//				response.sendRedirect(response.encodeRedirectURL("index.jsp"));
			}else {
//			��¼ʧ��
			request.setAttribute("msg", "�û������������");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
			request.getRequestDispatcher("validateCode.jsp").forward(request, response);
		}
	}else if(action.equals("logout")) {
//		sessionʧЧ
		session.invalidate();
		response.sendRedirect("validateCode.jsp");
	}
		out.close();
  }
}
