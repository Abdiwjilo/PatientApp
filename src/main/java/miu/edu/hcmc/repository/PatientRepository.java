package miu.edu.hcmc.repository;

import miu.edu.hcmc.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query(value="SELECT * FROM test.patient p where TIMESTAMPDIFF(YEAR, p.date_of_birth,CURDATE())>64",nativeQuery=true)
    List<Patient> findAllElderPatients();
}