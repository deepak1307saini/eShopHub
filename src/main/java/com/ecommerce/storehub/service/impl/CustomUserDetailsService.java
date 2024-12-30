package com.ecommerce.storehub.service.impl;

import com.ecommerce.storehub.entity.User;
import com.ecommerce.storehub.repository.UserRepository;
import com.ecommerce.storehub.repository.specification.AdminSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from the database
        User user = userRepository.findOne(AdminSpecification.hasUserName(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Return a Spring Security User object with username, password, and roles
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("ADMIN")
                .build();
    }
}