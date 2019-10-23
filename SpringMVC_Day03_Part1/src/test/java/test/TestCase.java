package test;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.Controller;

import controller.HelloController;

public class TestCase {
	//HandlerMapping”≥…‰≤‚ ‘
	@Test
	public void testHandlerMapping() {
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		HandlerMapping obj = ac.getBean("handlerMapping", HandlerMapping.class);
		Properties map = ac.getBean("urlMappings", Properties.class);
		System.out.println(obj);
		System.out.println(map);
	}
	
	@Test
	public void testHelloController() {
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		Controller obj = ac.getBean("helloController", HelloController.class);
		System.out.println(obj);
	}
	
//	≤‚ ‘ViewResolver≈‰÷√
	@Test
	public void testViewResolver() {
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		ViewResolver obj = ac.getBean("viewResolver", ViewResolver.class);
		System.out.println(obj);
	}
}
