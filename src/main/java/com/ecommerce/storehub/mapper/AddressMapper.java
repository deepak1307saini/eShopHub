package com.ecommerce.storehub.mapper;

import com.ecommerce.storehub.dto.AddressDTO;
import com.ecommerce.storehub.entity.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseEntityMapper<AddressDTO, Address> {
    AddressDTO toDto(Address address);
    Address toEntity(AddressDTO addressDTO);
    List<Address> toEntities(List<AddressDTO> addressDTOS);
    List<AddressDTO> toDtos(List<Address> addresses);
}
