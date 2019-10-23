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
	
	@Resource	//请求Spring注入资源userService
	private UserService userService;
	
	@RequestMapping("/login.do")
	public String loginForm() {
//		可以向表单界面传递一些参数
		return "login";//映射到login.jsp
	}
	
	@RequestMapping("/login-action1.do")
//	Spring MVC自动参数注入HttpServletRequest
	public String checkLogin1(HttpServletRequest request) {
		System.out.println("---方法一---");
//		优点直接简洁，缺点需要自己处理数据类型转换
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name);
		System.out.println(pwd);
		try {
			User user = userService.login(name, pwd);
//			登录成功将登录用户信息保存到当前会话中
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "success";//映射到success.jsp
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
//	映射表单属性不同的参数
	public String checkLogin2(String name, @RequestParam("pwd")String password, HttpServletRequest request) {
		System.out.println("---方法二---");
//		优点，自动转换数据类型，缺点可能出现数据类型转换异常
		System.out.println(name);
		System.out.println(password);
		try {
			User user = userService.login(name, password);
//			登录成功将登录用户信息保存到当前会话中
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
		System.out.println("---方法三---");
//		自动填充到bean对象
		System.out.println(user);
		try {
			user = userService.login(user.getName(), user.getPwd());
//			登录成功将登录用户信息保存到当前会话中
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
		System.out.println("---方法四---");
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			User user = userService.login(name, pwd);
//			登录成功将登录用户信息保存到当前会话中
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
		System.out.println("---方法五---");
		try {
			User user = userService.login(name, pwd);
//			登录成功将登录用户信息保存到当前会话中
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
		System.out.println("---方法六---");
		try {
			System.out.println("name=" + user.getName() + "password=" + user.getPwd());
			User u= userService.login(user.getName(), user.getPwd());
//			登录成功将登录用户信息保存到当前会话中
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
	
	private String[] msg = {"再来一次", "下次就对了", "没关系还有机会"};
	@ModelAttribute("next")
	public String getNext() {
		Random r = new Random();
		return msg[r.nextInt(msg.length)];
	}
}
