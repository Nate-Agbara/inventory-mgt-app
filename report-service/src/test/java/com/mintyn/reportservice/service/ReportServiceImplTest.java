package com.mintyn.reportservice.service;

import com.mintyn.basedomains.dto.OrderDto;
import com.mintyn.basedomains.dto.Status;
import com.mintyn.reportservice.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class ReportServiceImplTest {

    @Autowired
    private ReportService reportService;

    @Autowired
    private OrderRepository orderRepository;

    @DisplayName("save product verified")
    @Test
    public void saveProductDetails(){
        //given
        ReportServiceImpl reportServiceImpl = mock(ReportServiceImpl.class);

        OrderDto orderDto =  OrderDto.builder()
                .customerName("Nathan")
                .customerMobile("123456789")
                .amount(new BigDecimal(20.00))
                .productId(Long.valueOf(3))
                .dateCreated(LocalDateTime.now())
                .quantity(1)
                .status(Status.PENDING)
                .createdBy(null)
                .build();

        doNothing().when(reportServiceImpl).save(isA(OrderDto.class));
        reportServiceImpl.save(orderDto);
        verify(reportServiceImpl,times(1)).save(orderDto);

    }

}
