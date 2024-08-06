package com.kh.semi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {
	
	@RequestMapping("/home")
	public String home() {
		return "hi hello"; 
	}
}
