package com.uvg.directhealth.model.user;

import lombok.Data;

@Data
public class DoctorInfo {
    private int number;
    private String address;
    private String summary;
    private String certifications;
}
