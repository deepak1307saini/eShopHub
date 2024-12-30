package com.ecommerce.storehub.controller;

import com.ecommerce.storehub.dto.ProductCategoryDTO;
import com.ecommerce.storehub.service.ProductCategoryService;
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
@RequestMapping("/product-categories")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @PostMapping
    public ProductCategoryDTO createProductCategory(@RequestBody ProductCategoryDTO productCategoryDTO) {
        return productCategoryService.createProductCategory(productCategoryDTO);
    }

    @PostMapping("/bulk")
    public List<ProductCategoryDTO> createProductCategories(@RequestBody List<ProductCategoryDTO> productCategoryDTOS) {
        return productCategoryService.createProductCategories(productCategoryDTOS);
    }
}
