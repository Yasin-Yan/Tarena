package test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.ExampleBean;

public class TestCase {
//	测试实例化Spring容器示例
	@Test
	public void testInitContext() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		System.out.println(ac);
	}
	
//	测试Spring支持的多种JavaBean对象创建方式
	@Test
	public void testCreateBeanObject() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		1.用构造器来实例化的方式
//		利用Spring调用构造器GregorianCalendar创建Calendar实例
//		Calendar cal1 = (Calendar)ac.getBean("calendarObj1");	//方式1
		Calendar cal1 = ac.getBean("calendarObj1", Calendar.class); //方式2
		System.out.println("cal1: " + cal1);
		
//		2.使用静态工厂方法实例化的方式
//		利用Spring调用Calendar的静态工厂方法getInstance()创建Calendar实例
		Calendar cal2 = ac.getBean("calendarObj2", Calendar.class);
		System.out.println("cal2: " + cal2);
		
//		3.使用实例工厂方法实例化的方式
//		利用Spring创建GregorianCalendar对象作为工厂，调用getTime()方法创建Date类型对象实例
		Date date = ac.getBean("dateObj", Date.class);
		System.out.println("date: " + date);
	}
	
//	测试Bean对象的作用域
	@Test
	public void testExampleBean() {
//		实例化Spring容器示例
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		获取ExampleBean对象
		ExampleBean bean1 = ac.getBean("exampleBean", ExampleBean.class);
		ExampleBean bean2 = ac.getBean("exampleBean", ExampleBean.class);
		System.out.println(bean1 == bean2);
//		关闭Spring容器，注意AbstractApplicationContext类型定义了close()方法
		AbstractApplicationContext ctx = (AbstractApplicationContext)ac;
		ctx.close();
	}

}
