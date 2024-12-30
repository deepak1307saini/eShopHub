package com.ecommerce.storehub.dto;

import lombok.Data;

@Data
public abstract class BaseEntityDTO {
    private String createdBy;
    private String modifiedBy;
    private Long createdAt;
    private Long modifiedAt;
    private Boolean deleted;
}
