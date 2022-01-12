package miu.edu.hcmc.service;

import miu.edu.hcmc.dto.PatientDto;
import miu.edu.hcmc.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    List<Patient> findAll();
    Page<Patient> findAll(Pageable pageable);
    Patient findById(Long id);
    List<Patient> findAllElderPatients();
    Patient addPatient(PatientDto PatientDto);
    void removePatient(Long id);
    void removePatients();
    Patient updatePatient(Long id, PatientDto patientDto);
}
