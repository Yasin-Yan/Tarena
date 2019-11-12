package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Condition;
import entity.Emp;
import mapper.EmpDao;
import mapper.EmpMapper;

// 动态SQL语句拼接
public class TestCase1 {
	
//	if元素
	@Test
	public void testFindById() {
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		EmpDao dao = ac.getBean("empDao", EmpDao.class);
		Condition cond = new Condition();
//		cond.setDeptno(6337);
		List<Emp> list = dao.findByDept(cond);
		for (Emp emp : list) {
			System.out.println(emp.toString());
		}
		
	}
	
//	choose元素
	@Test
	public void testFindBySalary() {
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		EmpDao dao = ac.getBean("empDao", EmpDao.class);
		Condition cond = new Condition();
		cond.setSalary(2500.21);
		List<Emp> list = dao.findBySalary(cond);
		for (Emp emp : list) {
			System.out.println(emp.toString());
		}
	}
	
//	where元素
	@Test
	public void testFindByDeptAndSalary() {
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		EmpDao dao = ac.getBean("empDao", EmpDao.class);
		Condition cond = new Condition();
		cond.setDeptno(2000);
		cond.setSalary(3000.35);
		List<Emp> list = dao.findByDeptAndSalary(cond);
		for (Emp emp : list) {
			System.out.println(emp.toString());
		}
	}
	
//	set元素
	@Test
	public void testUpdateEmp() {
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		EmpDao dao = ac.getBean("empDao", EmpDao.class);
		EmpMapper mapper = ac.getBean("empMapper", EmpMapper.class);
		Emp emp = mapper.findEmp(1021);
		emp.setName("富贵");
		emp.setJob("president");
		dao.updateEmp(emp);
	}
	
//	trim元素代替where
	@Test
	public void testFindByDeptAndSalary2() {
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		EmpDao dao = ac.getBean("empDao", EmpDao.class);
		Condition cond = new Condition();
		cond.setDeptno(2000);
		cond.setSalary(2000.0);
		List<Emp> list = dao.findByDeptAndSalary2(cond);
		for (Emp emp : list) {
			System.out.println(emp.toString());
		}
	}
	
//	trim元素代替set
	@Test
	public void testUpdate2() {
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		EmpDao dao = ac.getBean("empDao", EmpDao.class);
		EmpMapper mapper = ac.getBean("empMapper", EmpMapper.class);
		Emp emp = mapper.findEmp(1000);
		emp.setSalary(6532.32);
		dao.updateEmp2(emp);
	}
	
//	foreach元素
	@Test
	public void testFindByIds() {
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		EmpDao dao = ac.getBean("empDao", EmpDao.class);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1000);
		list.add(1001);
		list.add(1018);
		list.add(1020);
		list.add(1021);
		Condition cond = new Condition();
		cond.setEmpnos(list);
		List<Emp> list2 = dao.findByIds(cond);
		for (Emp emp : list2) {
			System.out.println(emp.toString());
		}
	}
	
}
