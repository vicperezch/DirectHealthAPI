package com.uvg.directhealth.service;

import com.uvg.directhealth.model.Appointment;
import com.uvg.directhealth.model.user.User;
import com.uvg.directhealth.repository.AppointmentRepository;
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
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return new ResponseEntity<>(appointmentRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Appointment>> getAllAppointmentsByUserId(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        User user = optionalUser.get();
        if (user.getRole().equals(Role.DOCTOR)) {
            return new ResponseEntity<>(appointmentRepository.findAllByDoctorId(userId), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(appointmentRepository.findAllByPatientId(userId), HttpStatus.OK);
        }
    }

    public ResponseEntity<Appointment> getAppointmentById(String id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            return new ResponseEntity<>(appointment.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Appointment> save(Appointment appointment) {
        return new ResponseEntity<>(appointmentRepository.save(appointment), HttpStatus.CREATED);
    }

    public void deleteAppointmentById(String id) {
        appointmentRepository.deleteById(id);
    }
}
