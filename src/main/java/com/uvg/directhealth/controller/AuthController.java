package com.uvg.directhealth.controller;

import com.uvg.directhealth.dto.LoginDto;
import com.uvg.directhealth.dto.LoginResponseDto;
import com.uvg.directhealth.dto.RegisterDto;
import com.uvg.directhealth.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> register(@RequestBody RegisterDto registerDto) {
        return authService.signUp(registerDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
        return authService.signIn(loginDto);
    }
}
