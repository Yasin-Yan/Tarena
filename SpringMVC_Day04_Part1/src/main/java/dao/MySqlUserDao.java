package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import entity.User;

//持久层
@Repository("userDao")
public class MySqlUserDao implements UserDao, Serializable{
	private JDBCDataSource dataSource;
	public MySqlUserDao() {
	}
	
	@Autowired //按照类型自动装配
	public void setDataSource(@Qualifier("jdbcDataSource")JDBCDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public JDBCDataSource getDataSource() {
			return dataSource;
		}

	//	根据唯一用户名查询系统用户，如果没有找到用户信息返回null
	public User findByName(String name) {
		System.out.println("利用JDBC技术查找User信息");
		String sql = "select id, nam, pwd, phone from users where nam=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			User user = null;
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("nam"));
				user.setPwd(rs.getString("pwd"));
				user.setPhone(rs.getString("phone"));
			}
			rs.close();
			ps.close();
			return user;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			dataSource.close(conn);
		}
	}

	public User add(String name, String pwd, String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	public User find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}


}
