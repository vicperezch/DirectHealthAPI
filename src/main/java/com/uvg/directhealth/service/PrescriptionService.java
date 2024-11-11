package com.uvg.directhealth.service;

import com.uvg.directhealth.model.prescription.Prescription;
import com.uvg.directhealth.repository.PrescriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;

    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }

    public Prescription findById(String id) {
        Optional<Prescription> optionalPrescription = prescriptionRepository.findById(id);

        if (optionalPrescription.isPresent()) {
            return optionalPrescription.get();
        }

        return null;
    }

    public List<Prescription> findByPatientId(String patientId) {
        return prescriptionRepository.getAllByPatientId(patientId);
    }

    public Prescription save(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public void deleteById(String id) {
        prescriptionRepository.deleteById(id);
    }
}
