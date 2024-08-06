package com.kh.semi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {
	
	@RequestMapping("/home")
	public String home() {
		return "hi hello"; 
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "goodbye"; 
	}
	@RequestMapping("/hello222")
	public String heeeello() {
		return "goodbye2222"; 
	}
}
