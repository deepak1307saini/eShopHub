package com.ecommerce.storehub.service.impl;

import com.ecommerce.storehub.dto.AddressDTO;
import com.ecommerce.storehub.entity.Address;
import com.ecommerce.storehub.entity.User;
import com.ecommerce.storehub.mapper.AddressMapper;
import com.ecommerce.storehub.repository.AddressRepository;
import com.ecommerce.storehub.service.AddressService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    @Override
    public AddressDTO addAddress(AddressDTO addressDTO) {
        Address address = addressMapper.toEntity(addressDTO);
        Address savedAddress = addressRepository.save(address);
        return addressMapper.toDto(savedAddress);
    }
}
