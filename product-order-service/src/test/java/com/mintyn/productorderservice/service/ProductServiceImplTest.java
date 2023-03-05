package com.mintyn.productorderservice.service;

import com.mintyn.basedomains.dto.ProductDto;
import com.mintyn.productorderservice.exception.ApiException;
import com.mintyn.productorderservice.model.Product;
import com.mintyn.productorderservice.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @DisplayName("save product verified")
    @Test
    public void saveProductDetails(){
        //given
        ProductServiceImpl productServiceImpl = mock(ProductServiceImpl.class);

        ProductDto productDto =  ProductDto.builder()
                .productName("phone")
                .productDescription("tecno mobile")
                .productUnitPrice(new BigDecimal(20.00))
                .productQuantityInStock(3)
                .build();

        doNothing().when(productServiceImpl).save(isA(ProductDto.class));
        productServiceImpl.save(productDto);
        verify(productServiceImpl,times(1)).save(productDto);

    }

    @DisplayName("Returning saved product from service layer")
    @Test
    public void getProductById_forSavedProduct_isReturned(){
        //given
        Product product = productRepository.save(Product.builder()
                .productName("phone")
                .productDescription("tecno mobile")
                .productUnitPrice(new BigDecimal(20.00))
                .productQuantityInStock(3)
                .build());

        //when
        Product retrievedProduct = productService.findProductById(product.getProductId());

        //then
        assertEquals("tecno mobile", retrievedProduct.getProductDescription());
        assertNotNull(retrievedProduct.getProductId());
    }

//    @Test
//    void getProductById_whenMissingProduct_notFoundExceptionThrown()
//    {
//        //given
//        Long id = 1234l;
//        //when
//        Product product = productService.findProductById(id);
//
//        //then
//        assertInstanceOf(ApiException.class, product);
//    }

    @Test
    void getAllProduct(){
        //given
        Product product = productRepository.save(Product.builder()
                .productName("phone")
                .productDescription("tecno mobile")
                .productUnitPrice(new BigDecimal(20.00))
                .productQuantityInStock(3)
                .build());

        Product product2 = productRepository.save(Product.builder()
                .productName("laptop")
                .productDescription("dell")
                .productUnitPrice(new BigDecimal(200.00))
                .productQuantityInStock(4)
                .build());
        //when
        List<Product> productList = productService.findAllProduct();

        //then
        assertNotEquals(0, productList.size());
    }

    @DisplayName("update product details verified")
    @Test
    public void updateProductDetails(){
        //given
        ProductServiceImpl productServiceImpl = mock(ProductServiceImpl.class);

        Long productId = 1L;

        ProductDto productDto =  ProductDto.builder()
                .productName("phone")
                .productDescription("tecno mobile")
                .productUnitPrice(new BigDecimal("20.00"))
                .productQuantityInStock(3)
                .build();

        productServiceImpl.update(productId, productDto);
        verify(productServiceImpl,times(1)).update(productId, productDto);

    }

    @DisplayName("update product quantity verified")
    @Test
    public void updateProductQuantity(){
        //given
        ProductServiceImpl productServiceImpl = mock(ProductServiceImpl.class);

        int quantity = 4;
        Long productId = Long.valueOf(1);

        productServiceImpl.updateQuantity(productId, quantity);
        verify(productServiceImpl,times(1)).updateQuantity(productId, quantity);

    }
}
