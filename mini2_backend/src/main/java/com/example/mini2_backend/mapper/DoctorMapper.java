package com.example.mini2_backend.mapper;

import com.example.mini2_backend.dto.AppointmentDto;
import com.example.mini2_backend.dto.DoctorDto;
import com.example.mini2_backend.entity.Appointment;
import com.example.mini2_backend.entity.Doctor;

public class DoctorMapper {

    public static DoctorDto mapToDoctorDto(Doctor doctor) {
        return new DoctorDto(
                doctor.getDocId(),
                doctor.getDoctorName(),
                doctor.getSpecialist(),
                doctor.getExperience(),
                doctor.getAge(),
                doctor.getEmail(),
                doctor.getContactNo()

        );

    }
    public static Doctor mapToDoctor(DoctorDto doctorDto) {
        return new Doctor(
                doctorDto.getDocId(),
                doctorDto.getDoctorName(),
                doctorDto.getSpecialist(),
                doctorDto.getExperience(),
                doctorDto.getAge(),
                doctorDto.getEmail(),
                doctorDto.getContactNo()
        );

    }

}
