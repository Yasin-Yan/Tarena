package test;

import java.sql.Connection;
import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.ExampleBean;
import bean.MessageBean;
import dao.JDBCDataSource;
import dao.MySqlUserDao;
import dao.UserDao;
import entity.User;
import service.UserService;

public class TestCase {
	@Test
	public void test1() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		MessageBean bean = ac.getBean("messagebean", MessageBean.class);
		bean.execute();
	}
	
	@Test
	public void test2() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		MessageBean bean = ac.getBean("messagebean2", MessageBean.class);
		bean.execute();
	}
	
	@Test
	public void test3() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ExampleBean bean = ac.getBean("exampleBean", ExampleBean.class);
		bean.execute();
	}
	
	@Test
	public void test4() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ExampleBean bean1 = ac.getBean("exampleBean", ExampleBean.class);
		ExampleBean bean2 = ac.getBean("exampleBean", ExampleBean.class);
		System.out.println(bean1 == bean2);
		AbstractApplicationContext ctx = (AbstractApplicationContext)ac;
		ctx.close();
	}
	
	@Test
	public void testUserService() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserService service = ac.getBean("userService", UserService.class);
		System.out.println(service);
		User u = service.login("Tom", "123");
		System.out.println(u);
	}
	
	@Test
	public void testUserDao() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao dao = ac.getBean("userDao", UserDao.class);
		UserService service = ac.getBean("userService", UserService.class);
//		有对象输出说明Spring正确的创建了userDao组件
		System.out.println(dao);
//		返回true说明Spring正确的将userDao组件注入到service组件中
		System.out.println(dao == service.getUserDao());
		User u = service.login("Tom", "123");
	}
	
//	测试jdbcDataSource的创建和注入
	@Test
	public void testJdbcDataSource() {
		String config = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		JDBCDataSource dataSource = ac.getBean("jdbcDataSource", JDBCDataSource.class);
		MySqlUserDao userDao = ac.getBean("userDao", MySqlUserDao.class);
//		有对象输出说明Spring正确的创建了jdbcDataSource组件
		System.out.println(dataSource);
//		返回true说明Spring正确的将jdbcDataSource组件注入到userDao组件中
		System.out.println(dataSource == userDao.getDataSource());
		User user = userDao.findByName("Tom");
	}
	
//	测试Spring表达式注入
	@Test
	public void testJDBCProps() throws Exception{
		String config = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		Properties props = ac.getBean("jdbcProps", Properties.class);
		JDBCDataSource dataSource = ac.getBean("jdbcDataSource", JDBCDataSource.class);
		System.out.println(props);
		System.out.println(dataSource.getDriver());
		System.out.println(dataSource.getUrl());
		System.out.println(dataSource.getUser());
		System.out.println(dataSource.getPwd());
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
}
