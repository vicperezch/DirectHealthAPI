package com.uvg.directhealth.model.user;

import com.uvg.directhealth.util.Specialty;
import lombok.Data;

@Data
public class DoctorInfo {
    private int number;
    private String address;
    private String summary;
    private Specialty specialty;
}
