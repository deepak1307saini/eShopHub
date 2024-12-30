package com.ecommerce.storehub.service.impl;

import com.ecommerce.storehub.repository.UserRepository;
import com.ecommerce.storehub.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


}
