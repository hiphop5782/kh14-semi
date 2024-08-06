package com.kh.semi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {
	
	@RequestMapping("/home")
	public String home() {
		return "hi hello"; 
	}
	
	@RequestMapping("/home2")
	public String hello() {
		return "hi2222222"; 
	}
}
