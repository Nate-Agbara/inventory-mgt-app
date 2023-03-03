package com.mintyn.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String orderId;
    private String orderName;
    private int quantity;
    private BigDecimal price;
}
