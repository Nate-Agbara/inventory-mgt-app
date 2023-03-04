package com.mintyn.productorderservice.service;

import com.mintyn.basedomains.dto.OrderDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @DisplayName("Returning saved order from service layer before sending to kafka")
    @Test
    public void buildOrder_beforeSendingToKafka_isReturned(){
        //given
        OrderDto orderDto = OrderDto.builder()
                .customerName("Nathan")
                .customerMobile("123456789")
                .productId(Long.valueOf(1))
                .quantity(1)
                .build();

        //when
        OrderDto preparedOrder = orderService.save(orderDto);

        //then
        assertEquals("Nathan", preparedOrder.getCustomerName());
        assertNotNull(preparedOrder.getOrderId());
    }
}
