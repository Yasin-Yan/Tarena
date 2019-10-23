package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entity.User;
import service.NameOrPwdException;
import service.NullParamException;
import service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Resource	//����Springע����ԴuserService
	private UserService userService;
	
	@RequestMapping("/login.do")
	public String loginForm() {
//		����������洫��һЩ����
		return "login";//ӳ�䵽login.jsp
	}
	
	@RequestMapping("/login-action1.do")
//	Spring MVC�Զ�����ע��HttpServletRequest
	public String checkLogin1(HttpServletRequest request) {
		System.out.println("---����һ---");
//		�ŵ�ֱ�Ӽ�࣬ȱ����Ҫ�Լ�������������ת��
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name);
		System.out.println(pwd);
		try {
			User user = userService.login(name, pwd);
//			��¼�ɹ�����¼�û���Ϣ���浽��ǰ�Ự��
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "success";//ӳ�䵽success.jsp
		}catch(NameOrPwdException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return "login-form";
		}catch(NullParamException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return "redirect:login.do";
		}catch(RuntimeException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping("/login-action2.do")
//	ӳ������Բ�ͬ�Ĳ���
	public String checkLogin2(String name, @RequestParam("pwd")String password, HttpServletRequest request) {
		System.out.println("---������---");
//		�ŵ㣬�Զ�ת���������ͣ�ȱ����ܳ�����������ת���쳣
		System.out.println(name);
		System.out.println(password);
		try {
			User user = userService.login(name, password);
//			��¼�ɹ�����¼�û���Ϣ���浽��ǰ�Ự��
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "success";
		}catch(NameOrPwdException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return "login-form";
		}catch(NullParamException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return "login-form";
		}catch(RuntimeException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping("/login-action3.do")
	public String checkLogin3(User user, HttpServletRequest request) {
		System.out.println("---������---");
//		�Զ���䵽bean����
		System.out.println(user);
		try {
			user = userService.login(user.getName(), user.getPwd());
//			��¼�ɹ�����¼�û���Ϣ���浽��ǰ�Ự��
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "success";
		}catch(NameOrPwdException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return "login-form";
		}catch(NullParamException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return "login-form";
		}catch(RuntimeException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping("/login-action4.do")
	public ModelAndView checkLogin4(String name, String pwd, HttpServletRequest request) {
		System.out.println("---������---");
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			User user = userService.login(name, pwd);
//			��¼�ɹ�����¼�û���Ϣ���浽��ǰ�Ự��
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return new ModelAndView("success", data);
		}catch(NameOrPwdException e) {
			e.printStackTrace();
			data.put("message", e.getMessage());
			return new ModelAndView("login", data);
		}catch(NullParamException e) {
			e.printStackTrace();
			data.put("message", e.getMessage());
			return new ModelAndView("login", data);
		}catch(RuntimeException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return new ModelAndView("error", data);
		}
	}
	
	@RequestMapping("/login-action5.do")
	public String checkLogin5(String name, String pwd, ModelMap model, HttpServletRequest request) {
		System.out.println("---������---");
		try {
			User user = userService.login(name, pwd);
//			��¼�ɹ�����¼�û���Ϣ���浽��ǰ�Ự��
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "success";
		}catch(NameOrPwdException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "login";
		}catch(NullParamException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "login";
		}catch(RuntimeException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping("/login-action6.do")
	public String checkLogin6(@ModelAttribute("user") User user, ModelMap model, HttpServletRequest request) {
		System.out.println("---������---");
		try {
			System.out.println("name=" + user.getName() + "password=" + user.getPwd());
			User u= userService.login(user.getName(), user.getPwd());
//			��¼�ɹ�����¼�û���Ϣ���浽��ǰ�Ự��
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			return "success";
		}catch(NameOrPwdException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "login";
		}catch(NullParamException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "login";
		}catch(RuntimeException e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "error";
		}
	}
	
	private String[] msg = {"����һ��", "�´ξͶ���", "û��ϵ���л���"};
	@ModelAttribute("next")
	public String getNext() {
		Random r = new Random();
		return msg[r.nextInt(msg.length)];
	}
}
