package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.City;


@Controller
@RequestMapping("/day01")
public class HelloController{
	@RequestMapping("/hello.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("处理hello.do请求");
		ModelAndView mv = new ModelAndView("hello");
		return mv;// 调用hello.jsp
	}
	
	@RequestMapping("/city.do")
	private ModelAndView handleRequest() {
		System.out.println("处理city.do请求");
		List<City> cities = new ArrayList<City>();
		City city1 = new City(10001, "北京");
		City city2 = new City(10002, "上海");
		City city3 = new City(10003, "武汉");
		City city4 = new City(10004, "深圳");
		cities.add(city1);
		cities.add(city2);
		cities.add(city3);
		cities.add(city4);
		ModelAndView mv = new ModelAndView("city");
		mv.addObject("cities", cities);
		return mv;
	}
	
	
}
