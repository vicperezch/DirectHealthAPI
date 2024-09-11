package com.uvg.directhealth.model.prescription;

import com.mongodb.lang.NonNull;
import com.uvg.directhealth.model.user.User;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;

@Document("prescriptions")
@Data
public class Prescription {
    @MongoId
    private String id;
    @DBRef
    @NonNull private User doctor;
    @DBRef
    @NonNull private User patient;
    @NonNull private Date emissionDate;
    @NonNull private List<Medication> medicationList;
    private List<String> notes;
}
