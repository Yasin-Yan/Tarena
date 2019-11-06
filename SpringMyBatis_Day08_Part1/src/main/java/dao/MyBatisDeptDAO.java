package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Dept;

@Repository
public class MyBatisDeptDAO implements DeptDAO{
	
	private SqlSessionTemplate template;

	public SqlSessionTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		List<Dept> list = template.selectList("findAll");
		return list;
	}

}
