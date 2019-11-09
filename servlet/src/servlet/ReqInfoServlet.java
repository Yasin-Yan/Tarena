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
		//��ȡ������Ϣͷ������
		Enumeration e = request.getHeaderNames();
		while(e.hasMoreElements()) {
//			����Enumeration��ȡÿһ����Ϣͷ������
			String headerName = e.nextElement().toString();
//			�����Ϣͷ��ֵ��
			System.out.println(headerName+":"+request.getHeader(headerName));
		}
		System.out.println("����ʽ��"+request.getMethod());
		System.out.println("�����Э�����ࣺ"+request.getProtocol());
		System.out.println("������Դ·����"+request.getRequestURI());
		System.out.println("����·����Ϣ��"+request.getRequestURL());
		System.out.println("�����Servlet·����"+request.getServletPath());
	}
}
