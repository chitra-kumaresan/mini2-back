package com.example.mini2_backend.service;

import com.example.mini2_backend.dto.PatientDto;
import com.example.mini2_backend.entity.Patient;
import com.example.mini2_backend.exception.ResourceNotFoundException;
import com.example.mini2_backend.mapper.PatientMapper;
import com.example.mini2_backend.repo.BookingRepo;
import com.example.mini2_backend.repo.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor

public class PatientServiceImpl implements PatientService{
    private PatientRepo patientRepo;
    private BookingRepo bookingRepo;
    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient doctor = PatientMapper.mapToPatient(patientDto);
        Patient appointment1 =patientRepo.save(doctor);
        return PatientMapper.mapToPatientDto(appointment1);
    }

    @Override
    public PatientDto getPatientById(Long patId) {
        Patient medication=patientRepo.findById(patId)

                .orElseThrow(()->new ResourceNotFoundException("Patient", "id" ,patId));
        return PatientMapper.mapToPatientDto(medication);

    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> medications=patientRepo.findAll();
        return medications.stream()
                .map((PatientMapper::mapToPatientDto))
                .collect(Collectors.toList());

    }

    @Override
    public PatientDto updatePatient(Long patId, PatientDto updatedPatient) {
        Patient patient=patientRepo.findById(patId)
                .orElseThrow(()->new ResourceNotFoundException("Patient", "id" ,patId));
        patient.setPatientName(updatedPatient.getPatientName());
        patient.setEmail(updatedPatient.getEmail());
        patient.setProblem(updatedPatient.getProblem());
        patient.setContactNo(updatedPatient.getContactNo());
        patient.setAge(updatedPatient.getAge());

        Patient updated=patientRepo.save(patient);
        return PatientMapper.mapToPatientDto(updated);
    }

    @Override
    public void deletePatient(Long patId) {
        patientRepo.findById(patId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", patId));
        patientRepo.deleteById(patId);

    }

}
