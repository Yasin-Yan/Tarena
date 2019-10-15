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
//	setterע�����
	@Test
	public void testJDBCDataSource() throws Exception{
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		System.out.println(ac);
		JDBCDataSource ds = ac.getBean("dataSource", JDBCDataSource.class);
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
	
//	����������ע��
	@Test
	public void testMySqlUserDAO() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		��ȡMySqlUserDAOʵ��
		UserDAO userDAO = ac.getBean("userDAO", UserDAO.class);
//		��ѯ�û�����
		User tom = userDAO.findByName("Tom");
		System.out.println(tom);
	}
	
//	�Զ�����ע�����
	@Test
	public void testUserService() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		��ȡUserServiceʵ��
		UserService userService = ac.getBean("userService", UserService.class);
//		���õ�¼�����������Զ�ע����
		User tom = userService.login("Tom", "123");
		System.out.println(tom);
	}
}
