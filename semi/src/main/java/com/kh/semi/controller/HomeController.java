package com.kh.semi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "안녕";
	}

	@RequestMapping("/info")
	public String info() {
		return "홈페이지 정보";
	}

	@RequestMapping("/developer")
	public String developer() {
		return "개발자 정보";
	}

}






