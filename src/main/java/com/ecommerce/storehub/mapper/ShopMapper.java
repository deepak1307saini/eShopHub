package com.ecommerce.storehub.mapper;

import com.ecommerce.storehub.dto.ShopDTO;
import com.ecommerce.storehub.entity.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductCategoryMapper.class})
public interface ShopMapper extends BaseEntityMapper<ShopDTO, Shop> {

    @Mapping(target = "productCategories", source = "productCategories")
    @Mapping(target = "shopAddressId", source = "shopAddressId")
    ShopDTO toDto(Shop shop);

    @Mapping(target = "productCategories", ignore = true)
    @Mapping(target = "shopAddressId", source = "shopAddressId")
    Shop toEntity(ShopDTO shopDto);

    List<ShopDTO> toDtos(List<Shop> shops);
    List<Shop> toEntities(List<ShopDTO> shopDTOS);
}

