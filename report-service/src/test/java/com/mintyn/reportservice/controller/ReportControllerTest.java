package com.mintyn.reportservice.controller;

import com.mintyn.basedomains.constants.AppConstants;
import com.mintyn.basedomains.dto.OrderReportDto;
import com.mintyn.reportservice.service.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ReportControllerTest {

    @MockBean
    private ReportService reportService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getReport_ForSavedOrders_Returned() throws Exception
    {
        OrderReportDto orderReportDto = new OrderReportDto();
        orderReportDto.setTotalOrder(10);
        orderReportDto.setTotalOrderAmount(BigDecimal.valueOf(20000));
        orderReportDto.setDate("2023-03-04");

        OrderReportDto orderReportDto2 = new OrderReportDto();
        orderReportDto.setTotalOrder(20);
        orderReportDto.setTotalOrderAmount(BigDecimal.valueOf(30000));
        orderReportDto.setDate("2023-03-03");

        //given
        given(reportService.groupOrderByDate(anyString(), anyString())).willReturn(
                List.of(orderReportDto, orderReportDto2)
        );

        //when then
        mockMvc.perform(get(AppConstants.REPORT_URL +"?startDate=2023-03-04&stopDate=2023-03-04"))
                .andExpect(status().isOk());

    }

}
