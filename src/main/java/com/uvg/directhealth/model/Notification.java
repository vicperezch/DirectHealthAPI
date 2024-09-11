package com.uvg.directhealth.model;

import com.mongodb.lang.NonNull;
import com.uvg.directhealth.model.user.User;
import com.uvg.directhealth.util.NotificationType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Document("notifications")
@Data
public class Notification {
    @MongoId
    private String id;
    @DBRef
    @NonNull private User user;
    @NonNull private Date date;
    @Enumerated(EnumType.STRING)
    @NonNull private NotificationType type;
    @NonNull private String title;
    @NonNull private String message;
}
