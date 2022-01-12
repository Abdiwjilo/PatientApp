package miu.edu.hcmc.service.Implementation;

import miu.edu.hcmc.dto.PatientDto;
import miu.edu.hcmc.model.Patient;
import miu.edu.hcmc.repository.PatientRepository;
import miu.edu.hcmc.service.PatientService;
import miu.edu.hcmc.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Page<Patient> findAll(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient with id " + id + " not found"));
    }

    @Override
    public List<Patient> findAllElderPatients() {
        return patientRepository.findAllElderPatients();
    }

    @Override
    public void removePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient with id " + id + " not found for deletion"));

        patientRepository.delete(patient);
    }

    @Override
    public void removePatients() {
        patientRepository.deleteAll();
    }

    @Override
    public  Patient updatePatient(Long id, PatientDto patientDto){
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient with id" + id + " not found for update"));


        patient.setPatientNumber(patientDto.getPatientNumber());
        patient.setOutPatient(patientDto.getOutPatient());
        patient.setFullname(patientDto.getFullname());
        patient.setEmailAddress(patientDto.getEmailAddress());
        patient.setContactPhone(patientDto.getContactPhone());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patientRepository.flush();
        return patient;
    }


    @Override
    public Patient addPatient(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setPatientNumber(patientDto.getPatientNumber());
        patient.setOutPatient(patientDto.getOutPatient());
        patient.setFullname(patientDto.getFullname());
        patient.setEmailAddress(patientDto.getEmailAddress());
        patient.setContactPhone(patientDto.getContactPhone());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        return patientRepository.save(patient);
    }
}
