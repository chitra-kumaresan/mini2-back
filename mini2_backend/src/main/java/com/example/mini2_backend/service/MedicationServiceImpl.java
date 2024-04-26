package com.example.mini2_backend.service;


import com.example.mini2_backend.dto.MedicationDto;

import com.example.mini2_backend.entity.Medication;

import com.example.mini2_backend.exception.ResourceNotFoundException;

import com.example.mini2_backend.mapper.MedicationMapper;
import com.example.mini2_backend.repo.MedicationRepo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class MedicationServiceImpl implements  MedicationService{

    private MedicationRepo medicationRepo;
    @Override
    public MedicationDto createMedication(MedicationDto medicationDto) {
        Medication doctor = MedicationMapper.mapToMedication(medicationDto);
        Medication appointment1 =medicationRepo.save(doctor);
        return MedicationMapper.mapToMedicationDto(appointment1);
    }
    @Override
    public MedicationDto getMedicationById(Long medId) {
        Medication medication=medicationRepo.findById(medId)
                .orElseThrow(()->new ResourceNotFoundException("Medication", "id" ,medId));
        return MedicationMapper.mapToMedicationDto(medication);
    }
    @Override
    public List<MedicationDto> getAllMedications() {
        List<Medication> medications=medicationRepo.findAll();
        return medications.stream()
                .map((MedicationMapper::mapToMedicationDto))
                .collect(Collectors.toList());
    }
    @Override
    public MedicationDto updateMedication(Long medId, MedicationDto updatedMedication) {
        Medication medication=medicationRepo.findById(medId)
                .orElseThrow(()->new ResourceNotFoundException("Medication", "id" ,medId));
        medication.setPatientName(updatedMedication.getPatientName());
medication.setAppointmentDate(updatedMedication.getAppointmentDate());
medication.setEmail(updatedMedication.getEmail());
medication.setMedicationName(updatedMedication.getMedicationName());
medication.setMorning(updatedMedication.getMorning());
medication.setAfternoon(updatedMedication.getAfternoon());
medication.setNight(updatedMedication.getNight());
medication.setDoctorName(updatedMedication.getDoctorName());

              Medication updated=medicationRepo.save(medication);
              return MedicationMapper.mapToMedicationDto(updated);
    }
    @Override
    public void deleteMedication(Long medId) {
        medicationRepo.findById(medId)
                .orElseThrow(() -> new ResourceNotFoundException("Medication", "id", medId));
        medicationRepo.deleteById(medId);
    }

    @Override
    public MedicationDto getMedicationByEmail(String email) {
            Medication medication= medicationRepo.findByEmail(email);
            return MedicationMapper.mapToMedicationDto(medication);
    }

}
