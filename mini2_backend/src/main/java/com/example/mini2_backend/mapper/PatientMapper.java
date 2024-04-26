package com.example.mini2_backend.mapper;
import com.example.mini2_backend.dto.PatientDto;
import com.example.mini2_backend.entity.Patient;

public class PatientMapper {

    public static PatientDto mapToPatientDto(Patient patient) {
        return new PatientDto(
                patient.getPatId(),
                patient.getPatientName(),
                patient.getEmail(),
                patient.getProblem(),
                patient.getContactNo(),
                patient.getAge()

        );
}
    public static Patient mapToPatient(PatientDto patientDto) {
        return new Patient(
                patientDto.getPatId(),
                patientDto.getPatientName(),
                patientDto.getEmail(),
                patientDto.getProblem(),
                patientDto.getContactNo(),
                patientDto.getAge()
        );
    }

}
