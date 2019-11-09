package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Employee;
import util.DBUtil;

public class EmployeeDao {
	/**
	 * 查询所有员工
	 * @return List<Employee>
	 */
	Connection conn = null;
	PreparedStatement stat = null;
	ResultSet rs = null;
	DBUtil dbUtil = new DBUtil();
	
	public List<Employee> findAll() throws SQLException, ClassNotFoundException{
		List<Employee> emps = new ArrayList<Employee>();
		
		conn = dbUtil.getConnect();
		stat = conn.prepareStatement("SELECT * FROM t_emp");
		rs = stat.executeQuery();
		while(rs.next()) {
			Employee emp = new Employee(rs.getInt("id"), rs.getString("emp_name"), rs.getDouble("salary"), rs.getInt("age"));
			emps.add(emp);
		}
		conn.close();
		return emps;
	}
	
	/**
	 * 删除员工信息
	 * @param id
	 */
	public void delete(int id) throws SQLException, ClassNotFoundException{
		conn = dbUtil.getConnect();
		stat = conn.prepareStatement("DELETE from t_emp WHERE id=?");
		stat.setInt(1, id);
		stat.executeUpdate();
		conn.close();
	}
	
	/**
	 * 增加员工信息
	 * @param emp
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void save(Employee emp) throws SQLException, ClassNotFoundException{
		conn = dbUtil.getConnect();
		stat = conn.prepareStatement("INSERT INTO t_emp(emp_name,salary,age) VALUES(?, ?, ?)");
		stat.setString(1, emp.getName());
		stat.setDouble(2, emp.getSalary());
		stat.setInt(3, emp.getAge());
		stat.executeUpdate();
		conn.close();
	}
	
	/**
	 * 根据id查询员工信息
	 * @param id
	 */
	public Employee findById(int id) throws SQLException, ClassNotFoundException{
		Employee emp = null;
		conn = dbUtil.getConnect();
		stat = conn.prepareStatement("SELECT * FROM t_emp WHERE id=?");
		stat.setInt(1, id);
		rs = stat.executeQuery();
		if(rs.next())
			emp = new Employee(rs.getInt("id"), rs.getString("emp_name"), rs.getDouble("salary"), rs.getInt("age"));
		conn.close();
		return emp;
	}
	
	/**
	 * 修改员工信息
	 * @param emp
	 */
	public void modify(Employee emp) throws SQLException, ClassNotFoundException{
		conn = dbUtil.getConnect();
		stat = conn.prepareStatement("UPDATE t_emp SET emp_name = ?, salary = ?, age = ? WHERE id = ?");
		stat.setString(1, emp.getName());
		stat.setDouble(2, emp.getSalary());
		stat.setInt(3, emp.getAge());
		stat.setInt(4, emp.getId());
		stat.executeUpdate();
		conn.close();
	}
	
//	public static void main(String[] args) throws Exception {
//		EmployeeDao employeeDao = new EmployeeDao();
//		Employee emp = employeeDao.findById(2019);
//		System.out.println(emp.toString());
//	}
	
}
