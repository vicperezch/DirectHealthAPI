package com.uvg.directhealth.repository;

import com.uvg.directhealth.model.prescription.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrescriptionRepository extends MongoRepository<Prescription, String> {
    List<Prescription> getAllByPatientId(String userId);
    List<Prescription> getAllByDoctorId(String doctorId);
}
