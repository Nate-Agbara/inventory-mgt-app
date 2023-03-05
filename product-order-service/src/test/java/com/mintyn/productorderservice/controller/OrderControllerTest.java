package com.mintyn.productorderservice.controller;

import com.mintyn.basedomains.constants.AppConstants;
import com.mintyn.basedomains.dto.OrderDto;
import com.mintyn.basedomains.dto.Status;
import com.mintyn.productorderservice.model.Product;
import com.mintyn.productorderservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.mintyn.productorderservice.controller.ProductControllerTest.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

//    @MockBean
//    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateOrder() throws Exception {
        //given
        OrderDto orderDto = OrderDto.builder()
                .customerName("Nathan")
                .customerMobile("123456789")
                .productId(1L)
                .quantity(1)
                .build();
        //when //then
        mockMvc.perform(MockMvcRequestBuilders
                        .post(AppConstants.ORDER_URL)
                        .content(asJsonString(orderDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
}
