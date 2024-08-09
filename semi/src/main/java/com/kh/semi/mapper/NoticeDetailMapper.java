package com.kh.semi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kh.semi.dto.NoticeDto;

public class NoticeDetailMapper implements RowMapper<NoticeDto> {
	@Override
	public NoticeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		NoticeDto noticeDto = new NoticeDto();
		noticeDto.setLoginId(rs.getString("login_id"));
		noticeDto.setNoticeNo(rs.getInt("notice_no"));
		noticeDto.setNoticeTitle(rs.getString("notice_title"));
		noticeDto.setNoticeDate(rs.getDate("notice_date"));
		noticeDto.setNoticeCont(rs.getString("notice_cont"));
		noticeDto.setFileNo(rs.getInt("file_no"));
		noticeDto.setNoticeDelYn(rs.getString("notice_del_yn"));
		noticeDto.setLoginId2(rs.getString("login_id2"));
		return noticeDto;
	}
}
