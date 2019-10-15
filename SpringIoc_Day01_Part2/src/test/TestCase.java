package test;

import java.sql.Connection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.JDBCDataSource;
import dao.UserDAO;
import entity.User;
import service.UserService;

public class TestCase {
//	setter注入测试
	@Test
	public void testJDBCDataSource() throws Exception{
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		System.out.println(ac);
		JDBCDataSource ds = ac.getBean("dataSource", JDBCDataSource.class);
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
	
//	构造器参数注入
	@Test
	public void testMySqlUserDAO() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		获取MySqlUserDAO实例
		UserDAO userDAO = ac.getBean("userDAO", UserDAO.class);
//		查询用户对象
		User tom = userDAO.findByName("Tom");
		System.out.println(tom);
	}
	
//	自动属性注入测试
	@Test
	public void testUserService() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		获取UserService实例
		UserService userService = ac.getBean("userService", UserService.class);
//		调用登录方法，测试自动注入结果
		User tom = userService.login("Tom", "123");
		System.out.println(tom);
	}
}
