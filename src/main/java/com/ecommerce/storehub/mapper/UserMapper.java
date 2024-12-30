package com.ecommerce.storehub.mapper;


import com.ecommerce.storehub.dto.UserDTO;
import com.ecommerce.storehub.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface UserMapper extends BaseEntityMapper<UserDTO, User> {

    @Mapping(target = "addresses", ignore = true)
    UserDTO toDto(User user);

    @Mapping(target = "addresses", ignore = true)
    User toEntity(UserDTO userDto);

    List<UserDTO> toDtos(List<User> users);
    List<User> toEntities(List<UserDTO> userDTOS);
}
