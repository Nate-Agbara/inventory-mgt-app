package com.mintyn.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String orderId;
    private String customerName;
    private String customerMobile;
    private Long productId;
    private int quantity;
    private BigDecimal amount;
    private String createdBy;
    private LocalDateTime dateCreated;
    private String updatedBy;
    private LocalDateTime dateUpdated;
    private Status status;
}
