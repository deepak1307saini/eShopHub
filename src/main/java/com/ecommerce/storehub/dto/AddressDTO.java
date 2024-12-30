package com.ecommerce.storehub.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddressDTO extends BaseEntityDTO{
    private String addressId;
    private String userId;
    private String googleAddress;
    private float latitude;
    private float longitude;
    private String addressType;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private boolean isDefault;
    private String landmark;
}
