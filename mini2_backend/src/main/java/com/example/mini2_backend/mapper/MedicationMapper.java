package com.example.mini2_backend.mapper;

import com.example.mini2_backend.dto.DoctorDto;
import com.example.mini2_backend.dto.MedicationDto;
import com.example.mini2_backend.entity.Doctor;
import com.example.mini2_backend.entity.Medication;
import com.example.mini2_backend.entity.Patient;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class MedicationMapper {

    public static MedicationDto mapToMedicationDto(Medication medication) {
        return new MedicationDto(
                medication.getMedId(),
                medication.getPatientName(),
                medication.getEmail(),
                medication.getAppointmentDate(),
                medication.getMedicationName(),
                medication.getMorning(),
                medication.getAfternoon(),
                medication.getNight(),
                medication.getDoctorName()


        );
    }
    public static Medication mapToMedication(MedicationDto medicationDto) {
        return new Medication(
                medicationDto.getMedId(),
                medicationDto.getPatientName(),
                medicationDto.getEmail(),
                medicationDto.getAppointmentDate(),
                medicationDto.getMedicationName(),
                medicationDto.getMorning(),
                medicationDto.getAfternoon(),
                medicationDto.getNight(),
                medicationDto.getDoctorName()
        );
    }
}
