package test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import entity.Dept;
import entity.Dept1;
import entity.DeptMapper;

public class TestCase {
	
	@Test
	public void testSqlSession() throws IOException{
		String config = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(config);
//		创建SessionFactory对象
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
//		创建session
		SqlSession session = sf.openSession();
		System.out.println(session);
		
//		关闭session
		session.close();
	}
	
	@Test
	public void testInsert() throws IOException{
		String config = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		SqlSession session = sf.openSession();
		
//		调用addDept操作
//		Dept dept = new Dept();
//		dept.setDeptno(11);
//		dept.setDname("testing");
//		dept.setLoc("beijing");
//		session.insert("addDept", dept);
		
		for(int i = 1; i <= 10; i++) {
			Dept dept = new Dept();
			dept.setDeptno(12+i);
			dept.setDname("测试" + i);
			dept.setLoc("地区" + i);
			session.insert("addDept", dept);	
//			session.commit();
		}
		
		session.commit();
//		关闭
		session.close();
	}
	
	@Test
	public void testUpdate() throws IOException{
		String config = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		SqlSession session = sf.openSession();
		
//		调用findById方法
		Dept dept = (Dept)session.selectOne("findById", 11);
		dept.setDname("开发部");
		dept.setLoc("北京");
//		调用updateDept操作
		session.update("updateDept", dept);
		session.commit();
		session.close();
	}
	
	@Test
	public void testFindById() throws IOException{
		String config = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		SqlSession session = sf.openSession();
		
//		调用findById方法
		Dept dept = session.selectOne("findById", 10);
		System.out.println(dept.toString());
	}
	
	@Test
	public void testDeleteById() throws IOException{
		String config = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		SqlSession session = sf.openSession();
		
		int flag = session.delete("deleteById", 10);
		System.out.println(flag);
		session.commit();
		session.close();
	}
	
	@Test
	public void testFindAll() throws IOException{
		String config = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		SqlSession session = sf.openSession();
		
		List<Dept> list = session.selectList("findAll");
		for (Dept dept : list) {
			System.out.println(dept.toString());
		}
		session.clearCache();
	}
	
	@Test
	public void testFindPage() throws IOException{
		String config = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		SqlSession session = sf.openSession();
		
		int offset = 0;		//起点，从0开始
		int limit = 2;		//查几条
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Dept> list = session.selectList("findAll", null, rowBounds);
		for (Dept dept : list) {
			System.out.println(dept.toString());
		}
		session.close();
	}
	
	@Test
	public void testMap() throws IOException{
		String config = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		SqlSession session = sf.openSession();
		
		Map map = (Map)session.selectOne("findDept", 13);
		System.out.println(map.get("deptno") + " " + map.get("dname"));
		session.close();
	}
	
	@Test
	public void testMaps() throws IOException{
		String config = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		SqlSession session = sf.openSession();
		
		List<Map> list = session.selectList("findDepts");
		for (Map map : list) {
			System.out.println(map.get("deptno") + " " + map.get("dname"));
		}
		session.close();
	}
	
	@Test
	public void testDeptMapper() throws IOException{
		String config = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		SqlSession session = sf.openSession();
		
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		List<Dept> list = mapper.findAll();
		for (Dept dept : list) {
			System.out.println(dept.toString());
		}
		session.close();
	}
	
	@Test
	public void testResultMap() throws IOException{
		String config = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		SqlSession session = sf.openSession();
		
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		List<Dept1> list = mapper.findAll1();
		for (Dept1 dept1 : list) {
			System.out.println(dept1.toString());
		}
		session.close();
	}
}
