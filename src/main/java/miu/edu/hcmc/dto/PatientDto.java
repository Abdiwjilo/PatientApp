package miu.edu.hcmc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    @NotNull(message = "Please Enter patient Number")
    @Pattern(regexp = "([0-9]){3}-([0-9]){2}-([0-9]){4}",message = "Please Enter a valid Patient Id")
    @Column(nullable = false,unique = true)
    private String patientNumber;

    @Column(nullable = false)
    @NotNull(message = "Please Enter outPatient")
    private String outPatient;

    @Column(nullable = false)
    @NotNull(message = "Please Enter fullName")
    private String fullname;

    private String emailAddress;

    private String contactPhone;

    @Column(nullable = false)
    @NotNull(message = "Please Enter Date Birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateOfBirth;
}
