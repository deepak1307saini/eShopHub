package com.ecommerce.storehub.service;

import com.ecommerce.storehub.dto.UserDTO;

public interface AdminService {
    UserDTO createAdmin(UserDTO userDTO);

    UserDTO getAdmin(String adminId);
}
