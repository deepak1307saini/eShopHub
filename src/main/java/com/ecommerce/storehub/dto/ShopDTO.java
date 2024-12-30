package com.ecommerce.storehub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ShopDTO extends BaseEntityDTO {
    private String shopId;

    @NotBlank(message = "Owner ID cannot be blank.")
    private String ownerId;

    @Size(max = 255, message = "Shop name cannot be longer than 255 characters.")
    private String shopName;

    @Size(max = 500, message = "Shop description cannot be longer than 500 characters.")
    private String shopDescription;

    @NotBlank(message = "Shop address ID cannot be blank.")
    private String shopAddressId;

    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters.")
    private String shopPhone;

    @Email(message = "Shop email must be a valid email address.")
    private String shopEmail;

    private String shopCategory;
    private String paymentMethods;
//    private List<ProductDTO> products;
    private List<ProductCategoryDTO> productCategories;
}