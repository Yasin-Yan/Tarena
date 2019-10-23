package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.HelloController;

public class TestCase {
	@Test
	public void test1() {
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		HelloController helloController = ac.getBean("helloController", HelloController.class);
		System.out.println(helloController);
	}
}
