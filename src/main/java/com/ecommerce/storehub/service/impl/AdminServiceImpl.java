package com.ecommerce.storehub.service.impl;

import com.ecommerce.storehub.dto.UserDTO;
import com.ecommerce.storehub.entity.Address;
import com.ecommerce.storehub.entity.User;
import com.ecommerce.storehub.mapper.AddressMapper;
import com.ecommerce.storehub.mapper.UserMapper;
import com.ecommerce.storehub.repository.UserRepository;
import com.ecommerce.storehub.repository.specification.AdminSpecification;
import com.ecommerce.storehub.service.AdminService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private final EntityManager entityManager; // For detaching entities before saving them
    private final PasswordEncoder passwordEncoder; // Injected automatically by Spring


    @Override
    @Transactional
    public UserDTO createAdmin(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserDTO getAdmin(String adminId) {
        Specification<User> spec = Specification.where(AdminSpecification.hasUserId(adminId))
                .and(AdminSpecification.fetchUserAddresses());

        User user = userRepository.findOne(spec).orElseThrow(() -> new RuntimeException("Admin not found"));

        UserDTO adminDTO = userMapper.toDto(user);
        adminDTO.setAddresses(addressMapper.toDtos(user.getAddresses()));
        return adminDTO;
    }
}
