package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spring")
public class HelloController   {
	@RequestMapping("/hello.do")
	public String execute() throws Exception{
		System.out.println("Ö´ÐÐHelloController");
		return "hello";
	}
	
}
