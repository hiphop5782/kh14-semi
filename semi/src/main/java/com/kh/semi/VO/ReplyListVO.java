package com.kh.semi.VO;

import java.util.List;

import com.kh.semi.dto.ReplyDto;

import lombok.Data;

@Data
public class ReplyListVO {
	private List<ReplyDto> list;
	private int totalPage;
	private int currentPage;
}
