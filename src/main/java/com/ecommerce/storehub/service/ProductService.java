package com.ecommerce.storehub.service;

import com.ecommerce.storehub.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> createProducts(List<ProductDTO> productDTOS);
}
