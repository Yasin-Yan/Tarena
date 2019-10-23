package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.TestController;

public class TestCase {
	@Test
	public void TestCase1() {
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		TestController test = ac.getBean("testController",TestController.class);
		System.out.println(test);
	}
}
