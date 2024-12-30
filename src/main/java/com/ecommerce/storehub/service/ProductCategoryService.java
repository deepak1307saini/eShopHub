package com.ecommerce.storehub.service;

import com.ecommerce.storehub.dto.ProductCategoryDTO;

import java.util.List;

public interface ProductCategoryService {
    ProductCategoryDTO createProductCategory(ProductCategoryDTO productCategoryDTO);

    List<ProductCategoryDTO> createProductCategories(List<ProductCategoryDTO> productCategoryDTOS);
}
