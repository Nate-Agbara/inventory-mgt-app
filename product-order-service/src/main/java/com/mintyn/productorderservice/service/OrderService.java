package com.mintyn.productorderservice.service;

import com.mintyn.basedomains.constants.AppConstants;
import com.mintyn.basedomains.dto.OrderDto;
import com.mintyn.basedomains.dto.Status;
import com.mintyn.productorderservice.exception.ApiRequestException;
import com.mintyn.productorderservice.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class OrderService {

    private ProductService productService;

    public OrderService(ProductService productService) {
        this.productService = productService;
    }


    public OrderDto save(OrderDto orderDto) {
        Product product = productService.findProductById(orderDto.getProductId());
        if(product.getProductQuantityInStock() == 0)
            throw new ApiRequestException(AppConstants.PRODUCT_OUT_OF_STOCK);
        if(orderDto.getQuantity() > product.getProductQuantityInStock())
            throw new ApiRequestException(AppConstants.NOT_ENOUGH_IN_STOCK);
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal itemCost  = product.getProductUnitPrice()
                .multiply(BigDecimal.valueOf(orderDto.getQuantity()));
        total = total.add(itemCost);
        productService.updateQuantity(orderDto.getProductId(),
                product.getProductQuantityInStock() - orderDto.getQuantity());

        return OrderDto.builder()
                .customerName(orderDto.getCustomerName())
                .customerMobile(orderDto.getCustomerMobile())
                .productId(orderDto.getProductId())
                .quantity(orderDto.getQuantity())
                .amount(total)
                .status(Status.PENDING)
                .dateCreated(LocalDateTime.now())
                .build();
    }
}
