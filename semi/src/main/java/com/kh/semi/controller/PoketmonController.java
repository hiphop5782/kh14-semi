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
package com.kh.semi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;

//import com.kh.spring06.dto.PoketmonDto;


@Controller
@RequestMapping("/poketmon")
public class PoketmonController {

	
	@GetMapping("/insert") // GET방식만 처리
	public String insert() {
		return "/WEB-INF/views/poketmon/insert1.jsp";
	}

////	@RequestMapping("/insert2")//처리
//	@PostMapping("/insert")//POST방식만 처리
//	public String insert(@ModelAttribute PoketmonDto dto) {
//		dao.insert(dto);
//		return "redirect:insertComplete"; //리다이렉트(상대경로)
//	}
//	
//	@GetMapping("/insert") // GET방식만 처리
//	public String insert() {
//		return "/WEB-INF/views/poketmon/insert1.jsp";
//	}
//
//////	@RequestMapping("/insert2")//처리
////	@PostMapping("/insert")//POST방식만 처리
////	public String insert(@ModelAttribute PoketmonDto dto) {
////		dao.insert(dto);
////		return "redirect:insertComplete"; //리다이렉트(상대경로)
////	}
////	
//	// 이 메소드는 하나의 트랜잭션(세트메뉴)으로 취급됨
//	// Database의 C.U.D 작업을 여러 번 하는 경우 전체를 하나로 생각하여 처리
//	// 다 되거나, 다 안되거나 둘 중 하나밖에 없음
//	@Transactional
//	@PostMapping("/insert") // POST방식만 처리
//	public String insert(@ModelAttribute PoketmonDto poketmonDto, @RequestParam MultipartFile attach)
//			throws IllegalStateException, IOException {
//		// 1. 포켓몬스터 번호 생성
//		int poketmonNo = poketmonDao.sequence();
//		poketmonDto.setPoketmonNo(poketmonNo);
//
//		// 2. 포켓몬스터 등록
//		poketmonDao.insertWithSequence(poketmonDto);
//
//		// MultipartFile은 비어있을 수 있으므로 조건으로 검사를 해야한다.
//		if (!attach.isEmpty()) {
//			int attachmentNo = attachmentService.save(attach);
//			poketmonDao.connect(poketmonNo, attachmentNo);
//
	// 이 메소드는 하나의 트랜잭션(세트메뉴)으로 취급됨
	// Database의 C.U.D 작업을 여러 번 하는 경우 전체를 하나로 생각하여 처리
	// 다 되거나, 다 안되거나 둘 중 하나밖에 없음
//	@Transactional
////	@PostMapping("/insert") // POST방식만 처리
//	public String insert(@ModelAttribute PoketmonDto poketmonDto, @RequestParam MultipartFile attach)
//			throws IllegalStateException, IOException {
//		// 1. 포켓몬스터 번호 생성
//		int poketmonNo = poketmonDao.sequence();
//		poketmonDto.setPoketmonNo(poketmonNo);
//
//		// 2. 포켓몬스터 등록
//		poketmonDao.insertWithSequence(poketmonDto);
//
//		// MultipartFile은 비어있을 수 있으므로 조건으로 검사를 해야한다.
//		if (!attach.isEmpty()) {
//			int attachmentNo = attachmentService.save(attach);
//			poketmonDao.connect(poketmonNo, attachmentNo);
//
	

	String a="꼬부기";
	@RequestMapping("/insertComplete") // 완료
	public String insertComplete() {
		return "/WEB-INF/views/poketmon/insert3.jsp";
	}

	@RequestMapping("/detail")
	public String detail() {
		return "ㅎㅇ";
//		PoketmonDto dto = poketmonDao.selectOne(poketmonNo);
//		model.addAttribute("dto", dto);
//		return "/WEB-INF/views/poketmon/detail.jsp";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return"hello";
	}


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
	


}
