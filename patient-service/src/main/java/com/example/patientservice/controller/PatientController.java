package com.example.patientservice.controller;

import com.example.patientservice.dto.PatientRequestDTO;
import com.example.patientservice.dto.PatientResponseDTO;
import com.example.patientservice.dto.validators.CreatePatientValidationGroup;
import com.example.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")

@Tag(name = "Patient" , description = "API for managing patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    @Operation(summary = "Get patients")
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        return ResponseEntity.ok( patientService.getPatients());
    }

    @PostMapping
    @Operation(summary = "Create a new patient")
    public ResponseEntity<PatientResponseDTO> createPatient(@Validated({Default.class , CreatePatientValidationGroup.class}) @RequestBody PatientRequestDTO patientRequestDTO){
        PatientResponseDTO patientResponseDTO = patientService.createPatient(patientRequestDTO);
         return ResponseEntity.ok(patientResponseDTO);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update  a new patient")
    public ResponseEntity<PatientResponseDTO> updatePatient (@Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO , @PathVariable UUID id){
        PatientResponseDTO patientResponseDTO = patientService.updatePatient(id , patientRequestDTO);
        return ResponseEntity.ok(patientResponseDTO);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a patient")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
         patientService.deletePatient(id);
         return ResponseEntity.noContent().build();

    }
}
