package mapper;

import java.util.List;

import annotation.MyBatisRepository;
import entity.Emp;

@MyBatisRepository
public interface EmpMapper {
	
	public List<Emp> findAll();
	
	public void addEmp(Emp emp);
	
	public void deleteEmp(int id);
	
	public void updateEmp(Emp emp);
	
	public Emp findEmp(int id);
	
	public int findMaxId();
}
