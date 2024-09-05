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
	public String home2() {
		return "abcdefg"; 
	}

	@RequestMapping("/hello222")
	public String heeeello() {
		return "goodbye2222dfasfsdas"; 
	}
	
	@RequestMapping("/hello")
	public String hello222() {
		return "goodbye"; 

	}
}
