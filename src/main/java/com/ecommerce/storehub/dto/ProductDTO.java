package com.ecommerce.storehub.dto;

import com.ecommerce.storehub.enums.Status;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDTO extends BaseEntityDTO {
    private String productId;
    @NotBlank(message = "Shop ID cannot be blank.")
    private String shopId;

    @NotBlank(message = "Product Category ID cannot be blank.")
    private String productCategoryId;

    @NotBlank(message = "Product name cannot be blank.")
    @Size(max = 255, message = "Product name cannot exceed 255 characters.")
    private String productName;

    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be a positive value.")
    @Digits(integer = 10, fraction = 2, message = "Price must have up to 2 decimal places.")
    private Double price;

    @Min(value = 0, message = "Stock quantity must be a non-negative integer.")
    private Integer stockQuantity;

//    @EnumValidator(enumClass = Status.class, message = "Status must be one of 'ACTIVE', 'INACTIVE', or 'DISCONTINUED'."))
    private String status;
}
