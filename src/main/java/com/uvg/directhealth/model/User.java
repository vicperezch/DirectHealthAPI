package com.uvg.directhealth.model;

import com.uvg.directhealth.util.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Document("users")
@Data
public class User {
    @MongoId
    private String id;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String name;
    private String email;
    private String password;
    private Date birthDate;
    private String dpi;
    private String phoneNumber;
    private String medicalHistory;
    private DoctorInfo doctorInfo;
}
