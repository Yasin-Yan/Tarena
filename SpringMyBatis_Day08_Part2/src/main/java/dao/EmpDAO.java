package dao;

import java.util.List;

import annotation.MyBatisRepository;
import entity.Emp;

@MyBatisRepository
public interface EmpDAO {
	public List<Emp> findAll();
}
