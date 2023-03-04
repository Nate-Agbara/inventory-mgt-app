package com.mintyn.reportservice.kafka;

import com.mintyn.basedomains.dto.OrderEvent;
import com.mintyn.reportservice.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    private ReportService reportService;

    public OrderConsumer(ReportService reportService) {
        this.reportService = reportService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent){
        log.info(String.format("Order event received in report service => %s", orderEvent.toString()));
        reportService.save(orderEvent.getOrderDto());
    }

}
