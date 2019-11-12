package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Emp;


@Controller
@RequestMapping("/test")
public class JsonController {
	
	@RequestMapping("/test1.do")
	@ResponseBody
	public boolean test1() {
		return true;
	}
	
	@RequestMapping("/test2.do")
	@ResponseBody
	public Map<String, Object> test2(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "刘备");
		return map;
	}
	
	@RequestMapping("/test3.do")
	@ResponseBody
	public List<String> test3(){
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		return list;
	}
	
	@RequestMapping("/test4.do")
	@ResponseBody
	public Emp test4() {
		Emp emp = new Emp();
		emp.setId(1098);
		emp.setName("东皇太一");
		emp.setJob("法坦");
		emp.setMgr(654);
		emp.setSalary(21453.21);
		emp.setComm(452.23);
		emp.setDeptno(1002);
		emp.setHiredate(new Date(245893));
		return emp;
	}
	
	@RequestMapping("/test5.do")
	@ResponseBody
	public List<Emp> test5(){
		List<Emp> list = new ArrayList<Emp>();
		Emp emp1 = new Emp();
		emp1.setId(1098);
		emp1.setName("东皇太一");
		emp1.setJob("法坦");
		emp1.setMgr(654);
		emp1.setSalary(21453.21);
		emp1.setComm(452.23);
		emp1.setDeptno(1002);
		emp1.setHiredate(new Date(245893));
		
		Emp emp2 = new Emp();
		emp2.setId(1098);
		emp2.setName("东皇太二");
		emp2.setJob("法坦");
		emp2.setMgr(654);
		emp2.setSalary(21453.21);
		emp2.setComm(452.23);
		emp2.setDeptno(1002);
		emp2.setHiredate(new Date(245893));
		
		Emp emp3 = new Emp();
		emp3.setId(1098);
		emp3.setName("东皇太三");
		emp3.setJob("法坦");
		emp3.setMgr(654);
		emp3.setSalary(21453.21);
		emp3.setComm(452.23);
		emp3.setDeptno(1002);
		emp3.setHiredate(new Date(245893));
		
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		return list;
	}
}
