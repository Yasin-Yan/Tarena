package test;

import java.io.IOException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DeptDAO;
import entity.Dept;
import mapper.DeptMapper;


public class TestCase {
	
	@Test
	public void test1() throws IOException{
		String config = "applicationContext-scan.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		BasicDataSource dataSource = ac.getBean("myDataSource", BasicDataSource.class);
		SqlSessionFactory sf = ac.getBean("sqlSessionFactory1", SqlSessionFactory.class);
		System.out.println(dataSource);
		System.out.println(sf);
	}
	
	@Test
	public void testFindAll() throws IOException{
		String config = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		DeptMapper deptMapper = ac.getBean("deptMapper", DeptMapper.class);
		List<Dept> list = deptMapper.findAll();
		for (Dept dept : list) {
			System.out.println(dept.toString());
		}
	}
	
	@Test
	public void testScanFindAll() throws IOException{
		String config = "applicationContext-scan.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		DeptMapper deptMapper = ac.getBean("deptMapper", DeptMapper.class);
		List<Dept> list = deptMapper.findAll();
		for (Dept dept : list) {
			System.out.println(dept.toString());
		}
	}
	
	@Test
	public void testScanAnnotationFindAll() throws IOException{
		String config = "applicationContext-scan-annotation.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		DeptMapper mapper = ac.getBean("deptMapper", DeptMapper.class);
		List<Dept> list = mapper.findAll();
		for (Dept dept : list) {
			System.out.println(dept.toString());
		}
	}
	
	@Test
	public void testTemplateFindAll() throws IOException{
		String config = "applicationContext-template.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		DeptDAO dao = ac.getBean("myBatisDeptDAO", DeptDAO.class);
		List<Dept> list = dao.findAll();
		for (Dept dept : list) {
			System.out.println(dept.toString());
		}
	}
}
