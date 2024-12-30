package com.ecommerce.storehub.mapper;

import com.ecommerce.storehub.dto.ProductCategoryDTO;
import com.ecommerce.storehub.entity.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper extends BaseEntityMapper<ProductCategoryDTO, ProductCategory> {

    @Mapping(target = "shopId", source = "shopId")
    ProductCategoryDTO toDto(ProductCategory productCategory);

    @Mapping(target = "shopId", source = "shopId")
    ProductCategory toEntity(ProductCategoryDTO productCategoryDTO);

    List<ProductCategoryDTO> toDtos(List<ProductCategory> productCategories);
    List<ProductCategory> toEntities(List<ProductCategoryDTO> productCategoryDTOS);
}
