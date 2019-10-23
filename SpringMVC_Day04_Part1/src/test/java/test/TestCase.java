package test;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.HelloController;
import controller.LoginController;
import dao.JDBCDataSource;
import dao.MySqlUserDao;
import entity.User;
import service.UserService;

public class TestCase {
	@Test
	public void testUserService() throws Exception{
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		Properties obj = ac.getBean("jdbcProps", Properties.class);
		System.out.println(obj);
		JDBCDataSource ds = ac.getBean("jdbcDataSource", JDBCDataSource.class);
		System.out.println(ds);
		System.out.println(ds.getConnection());
		UserService service = ac.getBean("userService", UserService.class);
		User user = service.login("Tom", "123");
		System.out.println(user);
	}
	
	@Test
	public void test1() throws Exception{
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		MySqlUserDao userDao = ac.getBean("userDao", MySqlUserDao.class);
		JDBCDataSource ds = ac.getBean("jdbcDataSource", JDBCDataSource.class);
		System.out.println(userDao.getDataSource() == ds);
	}
	
	@Test
	public void test2() throws Exception{
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		HelloController helloController = ac.getBean("helloController", HelloController.class);
		System.out.println(helloController);
	}
	
	
}
