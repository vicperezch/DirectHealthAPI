package com.uvg.directhealth.dto;

import com.uvg.directhealth.util.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private String result;
    private String id;
    private Role role;
}
