package com.mintyn.reportservice.model;

import com.mintyn.basedomains.dto.OrderReportDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Schema(description = "OrderReport model")
@Entity(name = "customer_order")
@NamedNativeQuery(
        name = "find_order_report_dto",
        query =
                "SELECT DATE(o.date_created) as Date, COUNT(*) as Total_Order, "
                        + "SUM(o.amount) as Total_Order_Amount "
                        + "FROM customer_order o "
                        + "WHERE DATE(o.date_created) >= ?1 AND DATE(o.date_created) <= ?2 "
                        + "GROUP BY DATE(o.date_created) ",
        resultSetMapping = "order_report_dto"
)
@SqlResultSetMapping(
        name = "order_report_dto",
        classes = @ConstructorResult(
                targetClass = OrderReportDto.class,
                columns = {
                        @ColumnResult(name = "Date", type = String.class),
                        @ColumnResult(name = "Total_Order", type = Integer.class),
                        @ColumnResult(name = "Total_Order_Amount", type = BigDecimal.class)
                }
        )
)
public class OrderReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long orderId;
    private String date;
    private int totalOrder;
    private BigDecimal totalOrderAmount;
}
