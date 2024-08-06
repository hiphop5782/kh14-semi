package com.kh.semi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/poketmon")
public class PoketmonController {
	
	@RequestMapping("/detail")
	public String detail() {
		return "ㅎㅇ";
//		PoketmonDto dto = poketmonDao.selectOne(poketmonNo);
//		model.addAttribute("dto", dto);
//		return "/WEB-INF/views/poketmon/detail.jsp";
	}
	
}
