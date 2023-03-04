package com.mintyn.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderReportDto {
    private String date;
    private int totalOrder;
    private BigDecimal totalOrderAmount;
}
