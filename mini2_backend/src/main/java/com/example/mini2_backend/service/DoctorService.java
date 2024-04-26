package com.example.mini2_backend.service;

import com.example.mini2_backend.dto.AppointmentDto;
import com.example.mini2_backend.dto.DoctorDto;

import java.util.List;

public interface DoctorService {

    DoctorDto createDoctor(DoctorDto doctorDto);
    DoctorDto getDoctorById(Long docId);
    List<DoctorDto> getAllDoctors();
    DoctorDto updateDoctor(Long docId,DoctorDto updatedDoctor);
    void deleteDoctor(Long docId);
}
