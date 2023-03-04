package com.mintyn.productorderservice.controller;

import com.mintyn.basedomains.constants.AppConstants;
import com.mintyn.basedomains.dto.ProductDto;
import com.mintyn.productorderservice.model.Product;
import com.mintyn.productorderservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(AppConstants.PRODUCT_URL)
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        productService.save(productDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id ){
        return productService.findProductById(id);
    }

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.findAllProduct();
    }

    @PutMapping("/{id}")
    public Product updateWithPut(@PathVariable(value = "id") long productId,
                                   @RequestBody ProductDto productDto) {
        log.info("PUT /product/{}", productId);
        productService.update(productId, productDto);
        return productService.findProductById(productId);
    }

    @PatchMapping("/{id}")
    public Product updateWithPatch(@PathVariable(value = "id") long productId,
                                     @RequestBody ProductDto productDto) {
        log.info("PATCH /product/{}", productId);
        productService.update(productId, productDto);
        return productService.findProductById(productId);
    }

}
