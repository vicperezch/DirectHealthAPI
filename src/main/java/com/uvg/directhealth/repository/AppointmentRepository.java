package com.uvg.directhealth.repository;

import com.uvg.directhealth.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
}
