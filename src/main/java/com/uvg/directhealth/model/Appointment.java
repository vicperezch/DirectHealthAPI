package com.uvg.directhealth.model;

import com.mongodb.lang.NonNull;
import com.uvg.directhealth.model.user.User;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Document("appointments")
@Data
public class Appointment {
    @MongoId
    private String id;
    @DBRef
    @NonNull private User doctor;
    @DBRef
    @NonNull private User patient;
    @NonNull private Date date;
}
