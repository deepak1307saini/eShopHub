package com.ecommerce.storehub.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends BaseEntityDTO{
    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String status;
    private Long lastLogin;
    private String roleName;
    private List<AddressDTO> addresses;
}
