package com.ecommerce.storehub.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductCategoryDTO extends BaseEntityDTO {
    private String productCategoryId;
    private String shopId;
    private String categoryName;
    private String categoryDescription;
    private Integer orderPriority;
    private Boolean isActive;
    private List<ProductDTO> products;
}
