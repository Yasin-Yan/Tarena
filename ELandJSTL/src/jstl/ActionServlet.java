package jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list.do")
public class ActionServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		if(path.equals("list")) {
			List<Employee> emps = new ArrayList<Employee>();
			Employee e1 = new Employee();
			e1.setName("Luffy");
			e1.setGender("m");
			emps.add(e1);
			Employee e2 = new Employee();
			e2.setName("Zoro");
			e2.setGender("m");
			emps.add(e2);
			request.setAttribute("emps", emps);
			request.getRequestDispatcher("jstl04.jsp").forward(request, response);
		}
	}
}
