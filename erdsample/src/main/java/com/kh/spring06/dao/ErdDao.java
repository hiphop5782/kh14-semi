package com.kh.spring06.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.kh.spring06.dto.ErdDto;
import com.kh.spring06.mapper.ErdMapper;

@Repository
public class ErdDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ErdMapper erdMapper;
    
    // 등록
    public void insert(ErdDto dto) {
        // Insert 쿼리에서 stock_date를 SYSDATE 또는 CURRENT_TIMESTAMP로 설정
        String sql = "insert into stock(stock_no, stock_category, stock_name, stock_quantity, stock_date) " +
                     "values(stock_seq.nextval, ?, ?, ?, SYSDATE)";
        Object[] data = {dto.getStockCategory(), dto.getStockName(), dto.getStockQuantity()};
        jdbcTemplate.update(sql, data);
    }
    
    // 수정
    public boolean update(ErdDto dto) {
        String sql = "update stock set stock_category = ?, stock_name = ?, stock_quantity = ? where stock_no = ?";
        Object[] data = {dto.getStockCategory(), dto.getStockName(), dto.getStockQuantity(), dto.getStockNo()};
        return jdbcTemplate.update(sql, data) > 0;
    }

    // 삭제
    public boolean delete(int stockNo) {
        String sql = "delete from stock where stock_no = ?";
        Object[] data = {stockNo};
        return jdbcTemplate.update(sql, data) > 0;
    }

    // 조회 - 전체 리스트
    public List<ErdDto> selectList() {
        String sql = "select * from stock order by stock_no asc";
        return jdbcTemplate.query(sql, erdMapper);
    }

    // 조회 - 조건 검색
    public List<ErdDto> selectList(String column, String keyword) {
        String sql = "select * from stock where instr(" + column + ", ?) > 0 order by stock_no asc";
        Object[] data = {keyword};
        return jdbcTemplate.query(sql, erdMapper, data);
    }

    // 조회 - 특정 항목 상세 조회
    public ErdDto selectOne(int stockNo) {
        String sql = "select * from stock where stock_no = ?";
        Object[] data = {stockNo};
        List<ErdDto> list = jdbcTemplate.query(sql, erdMapper, data);
        return list.isEmpty() ? null : list.get(0);
    }
}
