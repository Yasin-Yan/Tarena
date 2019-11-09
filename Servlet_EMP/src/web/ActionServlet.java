package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;
import dao.EmployeeDao;
import dao.DBUtil;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet(urlPatterns = {"/addemp.do","/listemp.do","/deleteemp.do","/loademp.do","/modifyemp.do"})
public class ActionServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));

		if("/addemp".equals(action)) {
			String name = request.getParameter("name");
			Double salary = Double.valueOf(request.getParameter("salary"));
			Integer age = Integer.valueOf(request.getParameter("age"));
			
			EmployeeDao employeeDao = new EmployeeDao();
			Employee emp = new Employee();
			emp.setName(name);
			emp.setSalary(salary);
			emp.setAge(age);
			try {
				employeeDao.save(emp);
				response.sendRedirect("listemp.do");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				out.println("系统繁忙...");
				e.printStackTrace();
			}
		}else if("/listemp".equals(action)){
			EmployeeDao employeeDao = new EmployeeDao();
			List<Employee> emps;
			try {
				emps = employeeDao.findAll();
				request.setAttribute("emps", emps);
				request.getRequestDispatcher("listEmp1.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				out.println("系统繁忙...");
				e.printStackTrace();
			}
		}else if("/deleteemp".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeDao employeeDao = new EmployeeDao();
			try {
				employeeDao.delete(id);
				response.sendRedirect("listemp.do");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				out.println("系统繁忙...");
				e.printStackTrace();
			}
		}else if("/loademp".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeDao employeeDao = new EmployeeDao();
			Employee emp;
			try {
				emp = employeeDao.findById(id);
				request.setAttribute("emp", emp);
				request.getRequestDispatcher("modify.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				out.println("系统繁忙...");
				e.printStackTrace();
			}
		}else if("/modifyemp".equals(action)) {
			EmployeeDao employeeDao = new EmployeeDao();
			Employee emp = new Employee();
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			Double salary = Double.valueOf(request.getParameter("salary"));
			Integer age = Integer.valueOf(request.getParameter("age"));
			emp.setId(id);
			emp.setName(name);
			emp.setSalary(salary);
			emp.setAge(age);
			try {
				employeeDao.modify(emp);
				response.sendRedirect("listemp.do");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				request.setAttribute("error", "修改页面出错，请重试!");
				request.getRequestDispatcher("error.jsp").forward(request, response);
				e.printStackTrace();
			} 
		}
		
	}

}
