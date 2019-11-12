package mapper;

import java.util.List;

import annotation.MyBatisRepository;
import entity.Condition;
import entity.Emp;

@MyBatisRepository
public interface EmpDao {
	public List<Emp> findAll();
	
	public List<Emp> findByDept(Condition cond);
	
	public List<Emp> findBySalary(Condition cond);
	
	public List<Emp> findByDeptAndSalary(Condition cond);
	
	public void updateEmp(Emp emp);
	
	public List<Emp> findByDeptAndSalary2(Condition cond);
	
	public void updateEmp2(Emp emp);
	
	List<Emp> findByIds(Condition cond);
}
