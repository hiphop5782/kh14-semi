package com.kh.semi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@RequestMapping("/list")
	public String list() {
		return "list";
	}
	
	@RequestMapping("/detail")
	public String datail() {
		return "datail";
	}
	
}
