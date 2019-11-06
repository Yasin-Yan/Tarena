package web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.EmpDAO;
import entity.Emp;

@Controller
@RequestMapping("/emp")
public class EmpListController {
	private EmpDAO dao;

	@Autowired
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/list.do")
	public String execute(Model model) {
		List<Emp> list = dao.findAll();
		model.addAttribute("emps", list);
		return "emp_list";
	}
}
