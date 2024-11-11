package com.uvg.directhealth.controller;

import com.uvg.directhealth.model.prescription.Prescription;
import com.uvg.directhealth.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/prescription")
@AllArgsConstructor
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    @GetMapping("/all")
    public ResponseEntity<List<Prescription>> getAllPrescriptions(@RequestParam(required = false) String userId) {
        if (userId == null) {
            return prescriptionService.findAll();
        }

        return prescriptionService.findAllByUserId(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable("id") String id) {
        return prescriptionService.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Prescription> addPrescription(@RequestBody Prescription prescription) {
        return prescriptionService.save(prescription);
    }
}
