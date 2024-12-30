package com.ecommerce.storehub.controller;

import com.ecommerce.storehub.dto.UserDTO;
import com.ecommerce.storehub.service.AdminService;
import com.ecommerce.storehub.service.TwilioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admins")
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final TwilioService twilioService;

    @PostMapping
    public UserDTO createAdmin(@RequestBody UserDTO userDTO) {
        return adminService.createAdmin(userDTO);
    }

    @GetMapping("/{adminId}")
    public UserDTO getAdmin(@PathVariable String adminId){
        return adminService.getAdmin(adminId);
    }

    @GetMapping("/sendOTP/{phoneNumber}")
    public void sendOTP(@PathVariable String phoneNumber){
        twilioService.sendOtp(phoneNumber);
    }
}
