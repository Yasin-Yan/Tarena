package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello1Servlet
 */
@WebServlet("/hello1")
public class Hello1Servlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(name);
		out.println("<h1>Hello, " + name + "</h1>");
		String[] contacts = request.getParameterValues("contact");
		if(contacts != null) {
			out.print("<h1>Contact Information:</h1>");
			for (String info : contacts) {
				out.print("<h1>"+info+"</h1>");
			}
		}
		out.close();
	}
}
