package miu.edu.hcmc.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
@Data
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @NotNull(message = "Please Enter patient Number")
    @Pattern(regexp = "([A-Z]){2}-([0-9]){2}-([0-9]){2}",message = "Please Enter a valid Patient Id")
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
