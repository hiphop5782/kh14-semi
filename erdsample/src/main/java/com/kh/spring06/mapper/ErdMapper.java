package com.kh.spring06.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp; // Import for Timestamp
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.spring06.dto.ErdDto;

@Service // This annotation should be used on service classes, not mappers.
public class ErdMapper implements RowMapper<ErdDto> {
    @Override
    public ErdDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ErdDto dto = new ErdDto();
        dto.setStockNo(rs.getInt("stock_no"));
        dto.setStockName(rs.getString("stock_name"));
        dto.setStockQuantity(rs.getString("stock_quantity"));
        dto.setStockCategory(rs.getString("stock_category"));
        dto.setStockDate(rs.getTimestamp("stock_date")); // Map the stock_date column
        return dto;
    }
}
