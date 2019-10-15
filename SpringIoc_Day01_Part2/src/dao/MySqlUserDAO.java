package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class MySqlUserDAO implements UserDAO{
	private JDBCDataSource dataSource;
	
//	����MySqlUserDAO�������������JDBCDataSourceʵ��
	public MySqlUserDAO(JDBCDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
//	����Ψһ�û�����ѯϵͳ�û������û���ҵ��û���Ϣ����null
	public User findByName(String name) {
		// TODO Auto-generated method stub
		System.out.println("����JDBC��������User��Ϣ");
		String sql = "select id, nam, pwd, phone from users where nam = ?";
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
	
}
