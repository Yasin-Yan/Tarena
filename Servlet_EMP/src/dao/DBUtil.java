package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private String url = "jdbc:mysql://localhost:3306/mydatabase?useSSL=false&serverTimezone=CTT&characterEncoding=UTF-8";
	private String usr = "root";
	private String pwd = "123456";
	Connection conn = null;
	
	public Connection getConnect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, usr, pwd);
		return conn;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBUtil dbUtil = new DBUtil();
		Connection conn = dbUtil.getConnect();
		if(conn != null)System.out.println("success");
		else System.out.println("fail");
	}
}
