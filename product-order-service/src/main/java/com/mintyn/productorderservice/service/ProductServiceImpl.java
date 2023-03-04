package com.mintyn.productorderservice.service;

import com.mintyn.basedomains.constants.AppConstants;
import com.mintyn.basedomains.dto.ProductDto;
import com.mintyn.basedomains.dto.ProductStatus;
import com.mintyn.basedomains.dto.Status;
import com.mintyn.productorderservice.exception.ApiRequestException;
import com.mintyn.productorderservice.model.Product;
import com.mintyn.productorderservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional()
    public void save(ProductDto productDto) {
        productRepository.save(Product.builder()
                .productName(productDto.getProductName())
                .productDescription(productDto.getProductDescription())
                .productUnitPrice(productDto.getProductUnitPrice())
                .productQuantityInStock(productDto.getProductQuantityInStock())
                .status(ProductStatus.IN.name())
                .build());
    }

    @Override
    public Product findProductById(long id) {
        log.info("Inside findProductById");
        return productRepository.findById(id).orElseThrow(() ->
                new ApiRequestException(AppConstants.NO_SUCH_PRODUCT));
    }

    @Override
    public List<Product> findAllProduct() {
        log.info("Inside findAllProduct");
        return productRepository.findAll();
    }

    @Override
    public Product update(long productId, ProductDto productDto) throws ApiRequestException {
        log.info("Update all details of product {}", productId);
        Product product = findProductById(productId);
        product.setProductName(productDto.getProductName());
        product.setProductDescription(productDto.getProductDescription());
        product.setProductUnitPrice(productDto.getProductUnitPrice());
        product.setProductQuantityInStock(productDto.getProductQuantityInStock());
        if (productDto.getProductQuantityInStock() == 0) product.setStatus(ProductStatus.OUT.name());
        else product.setStatus(ProductStatus.IN.name());
        product.setDateUpdated(LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public Product updateQuantity(long productId, int quantity) throws ApiRequestException {
        log.info("Update quantity details of product {}", productId);
        Product product = findProductById(productId);
        product.setProductQuantityInStock(quantity);
        if(quantity == 0)
            product.setStatus(ProductStatus.OUT.name());
        product.setDateUpdated(LocalDateTime.now());
        return productRepository.save(product);
    }
}
