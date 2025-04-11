package com.example.patientservice.mapper;

import com.example.patientservice.dto.PatientRequestDTO;
import com.example.patientservice.dto.PatientResponseDTO;
import com.example.patientservice.model.Patient;
import lombok.Data;

import java.time.LocalDate;


public class PatientMapper {
    public static PatientResponseDTO convertToDTO(Patient patient){
        return new PatientResponseDTO(patient.getId().toString() , patient.getName().toString() , patient.getEmail().toString() , patient.getAddress().toString() , patient.getDateOfBirth().toString() , patient.getRegisterDate().toString());

    }
    public static Patient toModel(PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisterDate(LocalDate.parse(patientRequestDTO.getRegisterDate()));
        return patient;

    }
}
