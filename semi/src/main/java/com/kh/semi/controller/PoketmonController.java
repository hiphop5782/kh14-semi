package com.kh.semi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/poketmon")
public class PoketmonController {
	//이미지 제공 페이지
//		@RequestMapping("/image")
//		public String image(@RequestParam int poketmonNo) {
//			try {//플랜A-이미지가 있으면
//			Integer attachmentNo=poketmonDao.findImage(poketmonNo);
//			return "redirect:/attach/download?attachmentNo="+attachmentNo;
//			}
//			catch(Exception e) {//플랜B-이미지가 없으면
//				return "redirect:https://placehold.co/150";
//			}
//		}
	
}
