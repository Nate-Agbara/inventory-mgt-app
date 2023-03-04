package com.mintyn.reportservice.repository;

import com.mintyn.basedomains.dto.OrderReportDto;
import com.mintyn.reportservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(name = "find_order_report_dto", nativeQuery = true)
    List<OrderReportDto> countOrdersByDate(String startDate, String endDate);
}
