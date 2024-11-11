package com.uvg.directhealth.repository;

import com.uvg.directhealth.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findAllByDoctorId(String doctorId);
    List<Appointment> findAllByPatientId(String patientId);
}
