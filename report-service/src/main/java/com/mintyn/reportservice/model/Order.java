package com.mintyn.reportservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
@Entity
@Table(name = "customer_order")
@Schema(description = "Order model")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long orderId;

    @Column(name = "customer_name", nullable = false)
    @NotEmpty
    private String customerName;

    @Column(name = "customer_mobile", nullable = false)
    @NotEmpty
    private String customerMobile;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "order_quantity", nullable = false)
    @NotNull
    private int quantity;

    @Column(name = "amount", nullable = false, precision=20, scale=2)
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=20, fraction=2)
    private BigDecimal amount;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "date_created", nullable = true)
    private LocalDateTime dateCreated;

    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    @Column(name = "date_updated", nullable = true)
    private LocalDateTime dateUpdated;

    @Column(name = "status", nullable = false)
    private String status;
}
