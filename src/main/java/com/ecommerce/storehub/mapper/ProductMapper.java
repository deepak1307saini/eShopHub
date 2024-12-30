package com.ecommerce.storehub.mapper;

import com.ecommerce.storehub.dto.ProductDTO;
import com.ecommerce.storehub.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductCategoryMapper.class})
public interface ProductMapper extends BaseEntityMapper<ProductDTO, Product> {

    @Mapping(target = "shopId", source = "shopId")
    @Mapping(target = "productCategoryId", source = "productCategoryId")
    ProductDTO toDto(Product product);

    @Mapping(target = "shopId", source = "shopId")
    @Mapping(target = "productCategoryId", source = "productCategoryId")
    Product toEntity(ProductDTO productDTO);

    List<ProductDTO> toDtos(List<Product> products);
    List<Product> toEntities(List<ProductDTO> productDTOS);
}
