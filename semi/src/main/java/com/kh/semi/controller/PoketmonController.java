//package com.kh.semi.controller;
//
//import java.io.IOException;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import com.kh.spring06.dto.PoketmonDto;
//
//
//@Controller
//@RequestMapping("/poketmon")
//public class PoketmonController {
//




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
//
//		return "redirect:insertComplete"; // 리다이렉트(상대경로)
//	}
//
//	@RequestMapping("/insertComplete") // 완료
//	public String insertComplete() {
//		return "/WEB-INF/views/poketmon/insert3.jsp";
//	}
//
//	//이미지 제공 페이지
////		@RequestMapping("/image")
////		public String image(@RequestParam int poketmonNo) {
////			try {//플랜A-이미지가 있으면
////			Integer attachmentNo=poketmonDao.findImage(poketmonNo);
////			return "redirect:/attach/download?attachmentNo="+attachmentNo;
////			}
////			catch(Exception e) {//플랜B-이미지가 없으면
////				return "redirect:https://placehold.co/150";
////			}
////		}
//	
//
//	String a="꼬부기";
//	@RequestMapping("/insertComplete") // 완료
//	public String insertComplete() {
//		return "/WEB-INF/views/poketmon/insert3.jsp";
//	}
//
//}
//
//		return "redirect:insertComplete"; // 리다이렉트(상대경로)
//	}
//
//	@RequestMapping("/insertComplete") // 완료
//	public String insertComplete() {
//		return "/WEB-INF/views/poketmon/insert3.jsp";
//	}
//
//	//이미지 제공 페이지
////		@RequestMapping("/image")
////		public String image(@RequestParam int poketmonNo) {
////			try {//플랜A-이미지가 있으면
////			Integer attachmentNo=poketmonDao.findImage(poketmonNo);
////			return "redirect:/attach/download?attachmentNo="+attachmentNo;
////			}
////			catch(Exception e) {//플랜B-이미지가 없으면
////				return "redirect:https://placehold.co/150";
////			}
////		}
//	
//
//}
	



