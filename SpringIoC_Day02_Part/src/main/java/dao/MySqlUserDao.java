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

//�־ò�
@Repository("userDao")
public class MySqlUserDao implements UserDao, Serializable{
	private JDBCDataSource dataSource;
	public MySqlUserDao() {
	}
	
	@Autowired //���������Զ�װ��
	public void setDataSource(@Qualifier("jdbcDataSource")JDBCDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public JDBCDataSource getDataSource() {
			return dataSource;
		}

	//	����Ψһ�û�����ѯϵͳ�û������û���ҵ��û���Ϣ����null
	public User findByName(String name) {
		System.out.println("����JDBC��������User��Ϣ");
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
