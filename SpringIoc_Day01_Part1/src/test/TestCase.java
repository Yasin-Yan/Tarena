package test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.ExampleBean;

public class TestCase {
//	����ʵ����Spring����ʾ��
	@Test
	public void testInitContext() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		System.out.println(ac);
	}
	
//	����Spring֧�ֵĶ���JavaBean���󴴽���ʽ
	@Test
	public void testCreateBeanObject() {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		1.�ù�������ʵ�����ķ�ʽ
//		����Spring���ù�����GregorianCalendar����Calendarʵ��
//		Calendar cal1 = (Calendar)ac.getBean("calendarObj1");	//��ʽ1
		Calendar cal1 = ac.getBean("calendarObj1", Calendar.class); //��ʽ2
		System.out.println("cal1: " + cal1);
		
//		2.ʹ�þ�̬��������ʵ�����ķ�ʽ
//		����Spring����Calendar�ľ�̬��������getInstance()����Calendarʵ��
		Calendar cal2 = ac.getBean("calendarObj2", Calendar.class);
		System.out.println("cal2: " + cal2);
		
//		3.ʹ��ʵ����������ʵ�����ķ�ʽ
//		����Spring����GregorianCalendar������Ϊ����������getTime()��������Date���Ͷ���ʵ��
		Date date = ac.getBean("dateObj", Date.class);
		System.out.println("date: " + date);
	}
	
//	����Bean�����������
	@Test
	public void testExampleBean() {
//		ʵ����Spring����ʾ��
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		��ȡExampleBean����
		ExampleBean bean1 = ac.getBean("exampleBean", ExampleBean.class);
		ExampleBean bean2 = ac.getBean("exampleBean", ExampleBean.class);
		System.out.println(bean1 == bean2);
//		�ر�Spring������ע��AbstractApplicationContext���Ͷ�����close()����
		AbstractApplicationContext ctx = (AbstractApplicationContext)ac;
		ctx.close();
	}

}
