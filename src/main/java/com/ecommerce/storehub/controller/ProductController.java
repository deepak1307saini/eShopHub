package com.ecommerce.storehub.controller;

import com.ecommerce.storehub.dto.ProductDTO;
import com.ecommerce.storehub.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @PostMapping("/bulk")
    public List<ProductDTO> createProducts(@RequestBody List<ProductDTO> productDTOS) {
        return productService.createProducts(productDTOS);
    }
}
