package com.mintyn.productorderservice.model;

import com.mintyn.basedomains.constants.AppConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long productId;

    @Column(name = "product_name", nullable = false)
    @NotEmpty(message = AppConstants.PRODUCT_NAME_IS_MANDATORY)
    private String productName;

    @Column(name = "product_description", nullable = false)
    @NotEmpty(message = AppConstants.DESCRIPTION_IS_MANDATORY)
    private String productDescription;

    @Column(name = "unit_price", nullable = false, precision=20, scale=2)
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=20, fraction=2)
    private BigDecimal productUnitPrice;

    @Column(name = "quantity", nullable = false)
    @NotNull
    @Min(0)
    private int productQuantityInStock;

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
