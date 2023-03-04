package com.mintyn.basedomains.dto;

import jakarta.validation.constraints.*;
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

    @NotEmpty
    private String customerName;

    @NotEmpty
    @Min(11)
    @Max(11)
    private String customerMobile;

    @NotEmpty
    private Long productId;

    @NotEmpty
    private int quantity;

    @NotEmpty
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=20, fraction=2)
    private BigDecimal amount;

    private String createdBy;
    private LocalDateTime dateCreated;
    private String updatedBy;
    private LocalDateTime dateUpdated;
    private Status status;
}
