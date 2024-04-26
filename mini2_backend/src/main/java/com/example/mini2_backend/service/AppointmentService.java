package com.example.mini2_backend.service;

import com.example.mini2_backend.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {

    AppointmentDto createAppointment(AppointmentDto appointmentDto);
    AppointmentDto getAppointmentById(Long appId);
    List<AppointmentDto> getAllAppointments();
    AppointmentDto updateAppointment(Long appId,AppointmentDto updatedAppointment);
    void deleteAppointment(Long appId);

}
