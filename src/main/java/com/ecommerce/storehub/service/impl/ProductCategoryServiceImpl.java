package com.ecommerce.storehub.service.impl;

import com.ecommerce.storehub.dto.ProductCategoryDTO;
import com.ecommerce.storehub.dto.UserDTO;
import com.ecommerce.storehub.entity.ProductCategory;
import com.ecommerce.storehub.entity.User;
import com.ecommerce.storehub.mapper.ProductCategoryMapper;
import com.ecommerce.storehub.repository.ProductCategoryRepository;
import com.ecommerce.storehub.repository.specification.AdminSpecification;
import com.ecommerce.storehub.repository.specification.ProductCategorySpecification;
import com.ecommerce.storehub.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryMapper productCategoryMapper;
    private final ProductCategoryRepository productCategoryRepository;
    @Override
    public ProductCategoryDTO createProductCategory(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = productCategoryMapper.toEntity(productCategoryDTO);
        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        return productCategoryMapper.toDto(savedProductCategory);
    }

    @Override
    public List<ProductCategoryDTO> createProductCategories(List<ProductCategoryDTO> productCategoryDTOS) {
        List<ProductCategory> productCategories = productCategoryMapper.toEntities(productCategoryDTOS);
        List<ProductCategory> savedProductCategories = productCategoryRepository.saveAll(productCategories);
        return productCategoryMapper.toDtos(savedProductCategories);
    }
}
