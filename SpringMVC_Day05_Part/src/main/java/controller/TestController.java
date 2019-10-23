package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestController {
	@RequestMapping("/test.do")
	public void test() {
		System.out.println("log...");
		
	}
}
