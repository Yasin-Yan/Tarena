package mapper;

import java.util.List;

import annotation.MyBatisRepository;
import entity.Dept;

@MyBatisRepository
public interface DeptMapper {
	public List<Dept> findAll();
}
