package com.kh.spring06.dto;

import lombok.Data;
import java.util.Date;

@Data
public class ErdDto {
    private int stockNo;
    private String stockCategory;
    private String stockName;
    private String stockQuantity;
    private Date stockDate; // 입고 날짜 추가
}
