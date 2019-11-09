package session;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/count")
public class CountServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
//		��ȡsession����
		HttpSession session = request.getSession();
//		���sessionID
		System.out.println(session.getId());
//		��ȡ�󶨵ļ�����
		Integer count = (Integer)session.getAttribute("count");
		if(count==null) count = 1;
		else count++;//���ǵ�һ�η���
//		��session�а󶨼�����
		session.setAttribute("count", count);
//		�����ʾ��Ϣ
		out.println("���ǵ�" + count + "�η���");
		out.close();
	}
}
