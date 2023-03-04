package com.mintyn.reportservice.service;

import com.mintyn.basedomains.dto.OrderDto;
import com.mintyn.basedomains.dto.OrderReportDto;

import java.util.List;

public interface ReportService {

    void save(OrderDto orderDto);

    List<OrderReportDto> groupOrderByDate(String startDate, String endDate);
}
