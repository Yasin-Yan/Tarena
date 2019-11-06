package test;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpDAO;
import entity.Emp;

public class TestCase {
	@Test
	public void testFindAll() throws IOException{
		String config = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		EmpDAO mapper = ac.getBean("empDAO", EmpDAO.class);
		List<Emp> list = mapper.findAll();
		for (Emp emp : list) {
			System.out.println(emp.toString());
		}
	}
}
