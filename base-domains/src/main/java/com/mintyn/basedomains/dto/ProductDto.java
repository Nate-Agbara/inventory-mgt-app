package com.mintyn.basedomains.dto;

import com.mintyn.basedomains.constants.AppConstants;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {
    private String productName;
    private String productDescription;
    private BigDecimal productUnitPrice;
    private int productQuantityInStock;
}
