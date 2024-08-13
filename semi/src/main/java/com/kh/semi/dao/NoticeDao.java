package com.kh.semi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.semi.dto.NoticeDto;
import com.kh.semi.mapper.NoticeDetailMapper;
import com.kh.semi.mapper.NoticeListMapper;

@Repository
public class NoticeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NoticeListMapper noticeListMapper;
	@Autowired
	private NoticeDetailMapper noticeDetailMapper;
	
	//목록
	public List<NoticeDto> selectList(){
		String sql = "select "
						+ "login_id, notice_no, notice_title, notice_date, "
						+ "notice_cont, file_no, notice_del_yn, login_id2 "
					+ "from notice order by notice_no desc";
		return jdbcTemplate.query(sql, noticeListMapper);
	}
	//검색
	public List<NoticeDto> selectList(String column, String keyword) {
		String sql = "select "
						+ "login_id, notice_no, notice_title, notice_date, "
						+ "notice_cont, file_no, notice_del_yn, login_id2 "
					+ "from notice "
					+ "where instr(#1, ?) > 0 "
					+ "order by notice_no desc";
		sql = sql.replace("#1", column);
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, noticeListMapper, data);
	}
	//상세
	public NoticeDto selectOne(int noticeNo) {
		String sql = "select * from notice where notice_no=?";
		Object[] data = {noticeNo};
		List<NoticeDto> list = jdbcTemplate.query(sql, noticeDetailMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	//등록
	public int sequence() {
		String sql = "select notice_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert(NoticeDto noticeDto) {
		String sql = "insert into notice("
								+ "login_id, notice_no, notice_title, notice_date, "
								+ "notice_cont, file_no, notice_del_yn, login_id2 "
							+ ") "
								+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {
				noticeDto.getLoginId(), noticeDto.getNoticeNo(), noticeDto.getNoticeTitle(),
				noticeDto.getNoticeDate(), noticeDto.getNoticeCont(), noticeDto.getFileNo(),
				noticeDto.getNoticeDelYn(), noticeDto.getLoginId2()
		};
		jdbcTemplate.update(sql, data);
	}
	
	//삭제
	public boolean delete(int noticeNo) {
		String sql = "delete notice where notice_no = ?";
		Object[] data = {noticeNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	//수정
	public boolean update(NoticeDto noticeDto) {
		String sql = "update notice set "
						+ "notice_title=?, notice_date, notice_cont, notice_del_yn "
						+ "where notice_no=?";
		Object[] data = {
				noticeDto.getNoticeTitle(), noticeDto.getNoticeDate(), noticeDto.getNoticeCont(), noticeDto.getNoticeDelYn(),
				noticeDto.getNoticeNo()
		};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//조회수 증가
	public boolean updateNoticeViews(int noticeNo) {
		String sql = "update notice "
						+ "set notice_views=notice_views+1 "
						+ "where notice_no=?";
		Object[] data = {noticeNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//페이징이 적용된 목록
	public List<NoticeDto> selectListByPaging(int page, int size) {
		int endRow = page * size;
		int beginRow = endRow - (size-1);
		String sql = "select * from ("
							+ "select rownum rn, TMP.*from ("
								+ "select "
								+ "login_id, notice_no, notice_title, notice_date, "
								+ "notice_cont, file_no, notice_del_yn, login_id2 "
								+ "from notice "
								+ "where instr(#1. ?) > 0 "
								+ "order by notice_no desc"
							+ ")TMP"
						+ ") where  rn between ? and ?";
		sql =sql.replace("#1", column);
		Object[] data = {keyword, beginRow, endRow};
								
	}
}
