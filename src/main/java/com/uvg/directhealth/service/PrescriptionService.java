package com.uvg.directhealth.service;

import com.uvg.directhealth.model.prescription.Prescription;
import com.uvg.directhealth.model.user.User;
import com.uvg.directhealth.repository.PrescriptionRepository;
import com.uvg.directhealth.repository.UserRepository;
import com.uvg.directhealth.util.Role;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final UserRepository userRepository;

    public ResponseEntity<List<Prescription>> findAll() {
        List<Prescription> prescriptions = prescriptionRepository.findAll();

        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }

    public ResponseEntity<List<Prescription>> findAllByUserId(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        User user = optionalUser.get();

        if (user.getRole().equals(Role.DOCTOR)) {
            return new ResponseEntity<>(prescriptionRepository.getAllByDoctorId(userId), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(prescriptionRepository.getAllByPatientId(userId), HttpStatus.OK);
        }
    }

    public ResponseEntity<Prescription> findById(String id) {
        Optional<Prescription> optionalPrescription = prescriptionRepository.findById(id);

        if (optionalPrescription.isPresent()) {
            return new ResponseEntity<>(optionalPrescription.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Prescription> save(Prescription prescription) {
        return new ResponseEntity<>(prescriptionRepository.save(prescription), HttpStatus.CREATED);
    }

    public void deleteById(String id) {
        prescriptionRepository.deleteById(id);
    }
}
