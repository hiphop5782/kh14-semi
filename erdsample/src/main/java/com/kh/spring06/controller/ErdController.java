package com.kh.spring06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring06.dao.ErdDao;
import com.kh.spring06.dto.ErdDto;

@Controller
@RequestMapping("/stock")
public class ErdController {

    @Autowired
    private ErdDao erdDao;

    // 등록 페이지
    @GetMapping("/insert")
    public String insert() {
        return "/WEB-INF/views/stock/insert.jsp";
    }

    // 등록 처리
    @PostMapping("/insert")
    public String insert(@ModelAttribute ErdDto erdDto) {
        try {
            erdDao.insert(erdDto);
        } catch (Exception e) {
            e.printStackTrace();  // 로그에 에러 기록
            return "redirect:/stock/insert?error=true";
        }
        return "redirect:insertComplete";
    }

    // 등록 완료 페이지
    @RequestMapping("/insertComplete")
    public String insertComplete() {
        return "/WEB-INF/views/stock/insertComplete.jsp";
    }

    // 목록(검색) 페이지
    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(required = false) String column,
                       @RequestParam(required = false) String keyword) {
        List<ErdDto> list = null;
        try {
            boolean isSearch = column != null && keyword != null;
            list = isSearch ? erdDao.selectList(column, keyword) : erdDao.selectList();
        } catch (Exception e) {
            e.printStackTrace();  // 로그에 에러 기록
            return "redirect:/stock/list?error=true";
        }

        model.addAttribute("column", column);
        model.addAttribute("keyword", keyword);
        model.addAttribute("list", list);
        return "/WEB-INF/views/stock/list.jsp";
    }

    // 상세 조회 페이지
    @RequestMapping("/detail")
    public String detail(@RequestParam(name = "stockNo", required = false) Integer stockNo, Model model) {
        if (stockNo == null || stockNo <= 0) {
            return "redirect:/stock/list?error=true";
        }

        ErdDto dto = null;
        try {
            dto = erdDao.selectOne(stockNo);
        } catch (Exception e) {
            e.printStackTrace();  // 로그에 에러 기록
            return "redirect:/stock/list?error=true";
        }

        if (dto == null) {
            return "redirect:/stock/list?error=true";
        }

        model.addAttribute("dto", dto);
        return "/WEB-INF/views/stock/detail.jsp";
    }

    // 삭제 처리
    @RequestMapping("/delete")
    public String delete(@RequestParam int stockNo) {
        try {
            erdDao.delete(stockNo);
        } catch (Exception e) {
            e.printStackTrace();  // 로그에 에러 기록
            return "redirect:/stock/list?error=true";
        }
        return "redirect:list";
    }

    // 수정(입력) 페이지
    @GetMapping("/edit")
    public String edit(Model model, @RequestParam int stockNo) {
        ErdDto dto = null;
        try {
            dto = erdDao.selectOne(stockNo);
        } catch (Exception e) {
            e.printStackTrace();  // 로그에 에러 기록
            return "redirect:/stock/list?error=true";
        }

        if (dto == null) {
            return "redirect:/stock/list?error=true";
        }

        model.addAttribute("dto", dto);
        return "/WEB-INF/views/stock/edit.jsp";
    }

    // 수정 처리
    @PostMapping("/edit")
    public String edit(@ModelAttribute ErdDto dto) {
        try {
            boolean result = erdDao.update(dto);
            if (!result) {
                return "redirect:/stock/edit?stockNo=" + dto.getStockNo() + "&error=true";
            }
        } catch (Exception e) {
            e.printStackTrace();  // 로그에 에러 기록
            return "redirect:/stock/edit?stockNo=" + dto.getStockNo() + "&error=true";
        }
        return "redirect:detail?stockNo=" + dto.getStockNo();
    }
}

