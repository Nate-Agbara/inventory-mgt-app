package com.mintyn.productorderservice.controller;

import com.mintyn.basedomains.dto.OrderDto;
import com.mintyn.basedomains.dto.OrderEvent;
import com.mintyn.basedomains.dto.Status;
import com.mintyn.productorderservice.kafka.OrderProducer;
import com.mintyn.productorderservice.service.OrderService;
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
