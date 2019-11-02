package entity;

import java.util.HashMap;
import java.util.List;

public interface DeptMapper {
	public void addDept(Dept dept);
	
	public void updateDept(Dept dept);
	
	public Dept findById(int deptno);
	
	public void deleteById(int deptno);
	
	public List<Dept> findAll();
	
	public HashMap<String, Object> findDept(int deptno);
	
	public List<HashMap<String, Object>> findDepts();
	
	public List<Dept1> findAll1();
}
