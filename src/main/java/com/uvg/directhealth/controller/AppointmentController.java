package com.uvg.directhealth.controller;

import com.uvg.directhealth.model.Appointment;
import com.uvg.directhealth.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/appointment")
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> getAllAppointments(@RequestParam(required = false) String userId) {
        if (userId == null) {
            return appointmentService.getAllAppointments();
        }

        return appointmentService.getAllAppointmentsByUserId(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") String id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }
}
