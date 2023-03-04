package com.mintyn.reportservice.controller;

import com.mintyn.basedomains.constants.AppConstants;
import com.mintyn.basedomains.dto.OrderReportDto;
import com.mintyn.reportservice.service.ReportService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping(AppConstants.REPORT_URL)
public class ReportController {

    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<OrderReportDto> getAllOrder(@RequestParam(name = "startDate") @NotBlank String startDate,
                                            @RequestParam(name = "stopDate") @NotBlank String stopDate){
        return reportService.groupOrderByDate(startDate, stopDate);
    }
}
