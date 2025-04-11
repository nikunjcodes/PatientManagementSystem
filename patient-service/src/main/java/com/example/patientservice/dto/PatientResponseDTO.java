package com.example.patientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientResponseDTO {

    private String  id;

    private String name;
    private String email;


    private String address;

    private String  dateOfBirth;


    private String  registerDate;



}
