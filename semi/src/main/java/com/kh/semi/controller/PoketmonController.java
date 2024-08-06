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



////	@RequestMapping("/insert2")//처리
//	@PostMapping("/insert")//POST방식만 처리
//	public String insert(@ModelAttribute PoketmonDto dto) {
//		dao.insert(dto);
//		return "redirect:insertComplete"; //리다이렉트(상대경로)
//	}
//	
	// 이 메소드는 하나의 트랜잭션(세트메뉴)으로 취급됨
	// Database의 C.U.D 작업을 여러 번 하는 경우 전체를 하나로 생각하여 처리
	// 다 되거나, 다 안되거나 둘 중 하나밖에 없음




