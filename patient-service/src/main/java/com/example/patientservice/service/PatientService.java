package com.example.patientservice.service;

import com.example.patientservice.dto.PatientRequestDTO;
import com.example.patientservice.dto.PatientResponseDTO;
import com.example.patientservice.exception.EmailAlreadyExistsException;
import com.example.patientservice.mapper.PatientMapper;
import com.example.patientservice.model.Patient;
import com.example.patientservice.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<PatientResponseDTO> getPatients(){

        List< Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOS = patients.stream().map(patient -> PatientMapper.convertToDTO(patient)).toList();
        return patientResponseDTOS;
    }


    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw  new EmailAlreadyExistsException("A patient with this email already exists  "+patientRequestDTO.getEmail());
        }
        Patient newPatient = patientRepository.save(
                PatientMapper.toModel(patientRequestDTO)
        );
        return PatientMapper.convertToDTO(newPatient);
    }
}
