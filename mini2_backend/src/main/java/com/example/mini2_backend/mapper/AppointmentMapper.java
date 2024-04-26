package com.example.mini2_backend.mapper;

import com.example.mini2_backend.dto.AppointmentDto;
import com.example.mini2_backend.entity.Appointment;

public class AppointmentMapper {

    public static AppointmentDto mapToAppointmentDto(Appointment appointment) {
        return new AppointmentDto(
                appointment.getAppId(),
                appointment.getAvailableDate(),
                appointment.getDoctorName(),
                appointment.getSpecialist(),
                appointment.getExperience()


        );
    }

    public static Appointment mapToAppointment(AppointmentDto appointmentDto) {
        return new Appointment(
              appointmentDto.getAppId(),
                appointmentDto.getAvailableDate(),
                appointmentDto.getDoctorName(),
                appointmentDto.getSpecialist(),
                appointmentDto.getExperience()

        );
    }
}