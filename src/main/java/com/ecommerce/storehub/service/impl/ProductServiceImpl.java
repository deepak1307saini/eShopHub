package com.ecommerce.storehub.service.impl;

import com.ecommerce.storehub.dto.ProductDTO;
import com.ecommerce.storehub.entity.Product;
import com.ecommerce.storehub.mapper.ProductMapper;
import com.ecommerce.storehub.repository.ProductRepository;
import com.ecommerce.storehub.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public List<ProductDTO> createProducts(List<ProductDTO> productDTOS) {
        List<Product> products = productMapper.toEntities(productDTOS);
        List<Product> savedProducts = productRepository.saveAll(products);
        return productMapper.toDtos(savedProducts);
    }
}
