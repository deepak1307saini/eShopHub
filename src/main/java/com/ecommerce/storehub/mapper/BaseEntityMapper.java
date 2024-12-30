package com.ecommerce.storehub.mapper;

import com.ecommerce.storehub.dto.BaseEntityDTO;
import com.ecommerce.storehub.entity.BaseEntity;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseEntityMapper<D extends BaseEntityDTO, E extends BaseEntity> {
    D toDto(E entity);
    E toEntity(D dto);
}
