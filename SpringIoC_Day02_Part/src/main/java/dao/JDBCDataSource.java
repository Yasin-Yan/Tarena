package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//组件默认id为jDBCDataSource
@Component("jdbcDataSource")
public class JDBCDataSource implements Serializable{
	private String driver;
	
	@Value("#{jdbcProps.url}")
	private String url;
	
	@Value("#{jdbcProps.user}")
	private String user;
	
	@Value("#{jdbcProps.pwd}")
	private String pwd;
	
	public String getDriver() {
		return driver;
	}
	
	@Value("#{jdbcProps.driver}")
	public void setDriver(String driver) {
		try {
//			注册数据库驱动
			Class.forName(driver);
			this.driver = driver;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(url, user, pwd);
		return conn;
	}
	
	public void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
