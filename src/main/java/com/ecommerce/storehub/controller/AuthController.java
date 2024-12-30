package com.ecommerce.storehub.controller;

import com.ecommerce.storehub.dto.LoginRequest;
import com.ecommerce.storehub.dto.UserDTO;
import com.ecommerce.storehub.security.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        return jwtTokenUtil.generateToken(authentication);
    }

//    @PostMapping("/signup")
//    public ResponseEntity<?> signUp(@RequestBody UserDTO userDto) {
//        userDto.registerUser(userDto);
//        return ResponseEntity.ok("Registration successful. Please verify your email.");
//    }

//    @PostMapping("/signin")
//    public ResponseEntity<?> signIn(@RequestBody UserDto userDto) {
//        String token = userService.authenticateUser(userDto);
//        return ResponseEntity.ok(new AuthResponse(token));
//    }

//    @PostMapping("/forgot-password")
//    public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> request) {
//        userService.sendPasswordResetLink(request.get("email"));
//        return ResponseEntity.ok("Password reset link sent.");
//    }
//
//    @PostMapping("/send-verification-code")
//    public ResponseEntity<?> sendVerificationCode(@RequestBody Map<String, String> request) {
//        userService.sendVerificationCode(request.get("phoneNumber"));
//        return ResponseEntity.ok("Verification code sent.");
//    }
//
//    @PostMapping("/verify-code")
//    public ResponseEntity<?> verifyCode(@RequestBody VerificationRequest request) {
//        boolean isVerified = userService.verifyCode(request);
//        return isVerified ? ResponseEntity.ok("Phone number verified.") : ResponseEntity.badRequest().body("Invalid code.");
//    }
}
