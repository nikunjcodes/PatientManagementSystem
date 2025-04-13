package com.example.patientservice.dto;

import com.example.patientservice.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientRequestDTO {
    @NotBlank
    @Size(max = 100 , message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotBlank(message = "DOB cannot be blank")
    private String dateOfBirth;
    @NotBlank(groups = CreatePatientValidationGroup.class , message = "registration date cannot be blank")
    private String registerDate;

}
