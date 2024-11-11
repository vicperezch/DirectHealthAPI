package com.uvg.directhealth.dto;

import com.uvg.directhealth.model.user.DoctorInfo;
import com.uvg.directhealth.util.Role;
import lombok.Data;

import java.util.Date;

@Data
public class RegisterDto {
    private String email;
    private String name;
    private String password;
    private Date birthDate;
    private String dpi;
    private String phoneNumber;
    private String medicalHistory;
    private DoctorInfo doctorInfo;
    private Role role;
}
