package miu.edu.hcmc.controller;

import miu.edu.hcmc.dto.PatientDto;
import miu.edu.hcmc.model.Patient;
import miu.edu.hcmc.repository.PatientRepository;
import miu.edu.hcmc.service.Implementation.PatientServiceImpl;
import miu.edu.hcmc.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientServiceImpl patientService;



    @GetMapping(value = "/patients")
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @GetMapping(value = "/patients", params = "paged=true")
    public ResponseEntity<?> findAll(Pageable pageable) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, patientService.findAll(pageable));
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, patientService.findById(id));
    }

    @GetMapping("/elderpatients")
    public ResponseEntity<?> findAllElderPatients() {
        if (patientService.findAllElderPatients().isEmpty()){
            return ResponseHandler.respond("Null entities found", HttpStatus.NOT_FOUND);
        }
        else {
        return ResponseHandler.respond("You are looking all Elder Patient!", HttpStatus.OK, patientService.findAllElderPatients());}
    }

    @PostMapping("/patients")
    public ResponseEntity<?> addPatient(@RequestBody PatientDto patientDto) {
        Patient patient = patientService.addPatient(patientDto);
        if (patient!= null) {
            return ResponseHandler.respond("Successfully added a patient !", HttpStatus.OK, patient);
        } else {
            return ResponseHandler.respond("Null entities found", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "patients/{id}", consumes = "application/json")
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto) {
        Patient patient = patientService.updatePatient(id, patientDto);
        return ResponseHandler.respond("Successfully updated a patient!", HttpStatus.ACCEPTED, patient);
    }

    @DeleteMapping("patients/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        patientService.removePatient(id);
        return ResponseHandler.respond("Successfully deleted a patient!", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("patients")
    public ResponseEntity<?> deletePatients() {
        patientService.removePatients();
        return ResponseHandler.respond("Successfully deleted a patient!", HttpStatus.ACCEPTED);
    }
}
