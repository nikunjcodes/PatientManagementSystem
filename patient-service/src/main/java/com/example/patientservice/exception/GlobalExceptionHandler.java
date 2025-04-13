package com.example.patientservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    Logger log;
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String , String>> handleValidationExceptoin(MethodArgumentNotValidException ex){
        Map<String , String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> errors.put(error.getField(),  error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String , String>> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex){
       log.warn("Email address already exist {}", ex.getMessage());
        Map<String , String> errors = new HashMap<>();
        errors.put("message" , "Email already exists");
        return ResponseEntity.badRequest().body(errors);
    }
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String , String>> handlePatientNotFoundException(PatientNotFoundException patientNotFoundException){
        log.warn("Patient not found "+ patientNotFoundException.getMessage());
        Map<String , String> errors = new HashMap<>();
        errors.put("message" , "Patient not found");
        return ResponseEntity.badRequest().body(errors);

    }

}
