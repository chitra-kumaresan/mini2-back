package com.example.mini2_backend.service;

import com.example.mini2_backend.dto.DoctorDto;
import com.example.mini2_backend.dto.MedicationDto;

import java.util.List;

public interface MedicationService {

    MedicationDto createMedication(MedicationDto medicationDto);
    MedicationDto getMedicationById(Long medId);
    List<MedicationDto> getAllMedications();
    MedicationDto updateMedication(Long medId,MedicationDto updatedMedication);
    void deleteMedication(Long medId);
    MedicationDto getMedicationByEmail(String email);


}
