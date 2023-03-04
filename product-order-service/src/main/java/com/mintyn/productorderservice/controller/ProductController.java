package com.mintyn.productorderservice.controller;

import com.mintyn.basedomains.constants.AppConstants;
import com.mintyn.basedomains.dto.ProductDto;
import com.mintyn.productorderservice.model.Product;
import com.mintyn.productorderservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESS"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "UNAUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND")
    })
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        productService.save(productDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "getProduct/id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "UNAUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND")
    })
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id ){
        return productService.findProductById(id);
    }

    @Operation(summary = "getAllProduct")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "UNAUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND")
    })
    @GetMapping
    public List<Product> getAllProduct(){
        return productService.findAllProduct();
    }

    @Operation(summary = "updateProductWithPut/id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "UNAUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND")
    })
    @PutMapping("/{id}")
    public Product updateWithPut(@PathVariable(value = "id") long productId,
                                   @RequestBody ProductDto productDto) {
        log.info("PUT /product/{}", productId);
        productService.update(productId, productDto);
        return productService.findProductById(productId);
    }

    @Operation(summary = "updateProductWithPatch/id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESS"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "UNAUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND")
    })
    @PatchMapping("/{id}")
    public Product updateWithPatch(@PathVariable(value = "id") long productId,
                                     @RequestBody ProductDto productDto) {
        log.info("PATCH /product/{}", productId);
        productService.update(productId, productDto);
        return productService.findProductById(productId);
    }

}
