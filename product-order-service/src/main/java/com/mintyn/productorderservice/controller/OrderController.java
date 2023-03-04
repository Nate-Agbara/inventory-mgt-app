package com.mintyn.productorderservice.controller;

import com.mintyn.basedomains.dto.OrderDto;
import com.mintyn.basedomains.dto.OrderEvent;
import com.mintyn.basedomains.dto.Status;
import com.mintyn.productorderservice.kafka.OrderProducer;
import com.mintyn.productorderservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private OrderProducer orderProducer;

    private OrderService orderService;

    public OrderController(OrderProducer orderProducer, OrderService orderService) {
        this.orderProducer = orderProducer;
        this.orderService = orderService;
    }

    @Operation(summary = "order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESS"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "UNAUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND")
    })
    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderDto orderDto){
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus(Status.PENDING);
        orderEvent.setMessage("order status is in pending state");
        orderEvent.setOrderDto(orderService.save(orderDto));

        orderProducer.sendMessage(orderEvent);
        return new ResponseEntity<>("order placed successfully...", HttpStatus.CREATED);
    }
}
