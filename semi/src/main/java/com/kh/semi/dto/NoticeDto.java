package com.kh.semi.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class NoticeDto {
	private String loginId;
	private int noticeNo;
	private String noticeTitle;
	private Date noticeDate;
	private String noticeCont;
	private int fileNo;
	private String noticeDelYn;
	private String loginId2;
	
	public String getNoticeDate() {
		Timestamp stamp = new Timestamp(noticeDate.getTime());
		LocalDateTime time = stamp.toLocalDateTime();
		LocalDate today = LocalDate.now();
		
		if(time.toLocalDate().equals(today)) {
			return time.format(DateTimeFormatter.ofPattern("HH:mm"));
		}
		else {
			return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
	}
}
