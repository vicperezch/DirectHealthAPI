package com.uvg.directhealth.service;

import com.uvg.directhealth.dto.LoginDto;
import com.uvg.directhealth.dto.LoginResponseDto;
import com.uvg.directhealth.dto.RegisterDto;
import com.uvg.directhealth.model.user.User;
import com.uvg.directhealth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public ResponseEntity<HttpStatus> signUp(RegisterDto registerDto) {
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User userToRegister = User.builder()
                .email(registerDto.getEmail())
                .dpi(registerDto.getDpi())
                .name(registerDto.getName())
                .birthDate(registerDto.getBirthDate())
                .password(registerDto.getPassword())
                .doctorInfo(registerDto.getDoctorInfo())
                .role(registerDto.getRole())
                .phoneNumber(registerDto.getPhoneNumber())
                .medicalHistory(registerDto.getMedicalHistory())
                .build();

        userRepository.save(userToRegister);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<LoginResponseDto> signIn(LoginDto loginDto) {
        Optional<User> optionalUser = userRepository.findByEmail(loginDto.getEmail());
        LoginResponseDto response = new LoginResponseDto();

        if (optionalUser.isEmpty()) {
            response.setResult("ERROR");

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        User user = optionalUser.get();
        if (!user.getPassword().equals(loginDto.getPassword())) {
            response.setResult("ERROR");

            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

        response.setResult("SUCCESS");
        response.setRole(user.getRole());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
