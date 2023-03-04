package com.mintyn.reportservice.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mintyn.basedomains.constants.AppConstants;
import com.mintyn.basedomains.dto.OrderReportDto;
import com.mintyn.reportservice.service.ReportService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
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
    public List<OrderReportDto> getAllOrder(@RequestParam(name = "startDate")
                                                @Pattern(regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$",
                                                        message = "value should be in format YYYY-MM-DD")
                                                        String startDate,
                                            @RequestParam(name = "stopDate")
                                            @Pattern(regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$",
                                                    message = "value should be in format YYYY-MM-DD")
                                                    String stopDate){
        return reportService.groupOrderByDate(startDate, stopDate);
    }
}
