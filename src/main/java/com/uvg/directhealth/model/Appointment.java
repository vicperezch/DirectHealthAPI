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
    @NonNull private String doctorId;
    @NonNull private String patientId;
    @NonNull private Date date;
}
