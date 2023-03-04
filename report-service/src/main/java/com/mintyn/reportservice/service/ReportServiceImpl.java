package com.mintyn.reportservice.service;

import com.mintyn.basedomains.dto.OrderDto;
import com.mintyn.basedomains.dto.OrderReportDto;
import com.mintyn.reportservice.model.Order;
import com.mintyn.reportservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ReportServiceImpl implements ReportService {

    private OrderRepository orderRepository;

    public ReportServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public void save(OrderDto orderDto) {
        orderRepository.save(Order.builder()
                        .customerName(orderDto.getCustomerName())
                        .customerMobile(orderDto.getCustomerMobile())
                        .amount(orderDto.getAmount())
                        .dateCreated(orderDto.getDateCreated())
                        .productId(orderDto.getProductId())
                        .quantity(orderDto.getQuantity())
                        .status(orderDto.getStatus().name())
                        .createdBy(orderDto.getCreatedBy())
                .build());
    }

    @Override
    public List<OrderReportDto> groupOrderByDate(String startDate, String endDate) {
        log.info("Inside groupOrderByDate");
        return orderRepository.countOrdersByDate(startDate, endDate);

    }

}
