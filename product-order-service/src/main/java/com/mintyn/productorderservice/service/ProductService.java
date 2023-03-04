package com.mintyn.productorderservice.service;

import com.mintyn.basedomains.dto.ProductDto;
import com.mintyn.productorderservice.exception.ApiRequestException;
import com.mintyn.productorderservice.model.Product;

import java.util.List;

public interface ProductService {

    void save(ProductDto product);

    Product findProductById(long id);

    List<Product> findAllProduct();

    Product update(long productId, ProductDto productDto) throws ApiRequestException;

    Product updateQuantity(long productId, int quantity) throws ApiRequestException;
}
