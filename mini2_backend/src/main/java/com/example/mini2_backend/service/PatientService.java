package com.example.mini2_backend.service;

import com.example.mini2_backend.dto.MedicationDto;
import com.example.mini2_backend.dto.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto createPatient(PatientDto patientDto);
    PatientDto getPatientById(Long patId);
    List<PatientDto> getAllPatients();
    PatientDto updatePatient(Long patId,PatientDto updatedPatient);
    void deletePatient(Long patId);

}
