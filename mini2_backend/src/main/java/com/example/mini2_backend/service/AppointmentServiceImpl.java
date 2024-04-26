package com.example.mini2_backend.service;

import com.example.mini2_backend.dto.AppointmentDto;
import com.example.mini2_backend.entity.Appointment;
import com.example.mini2_backend.entity.Patient;
import com.example.mini2_backend.exception.ResourceNotFoundException;
import com.example.mini2_backend.mapper.AppointmentMapper;
import com.example.mini2_backend.repo.AppointmentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements  AppointmentService{
    private AppointmentRepo appointmentRepo;
    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {

        Appointment appointment=AppointmentMapper.mapToAppointment(appointmentDto);
        Appointment appointment1 =appointmentRepo.save(appointment);
        return AppointmentMapper.mapToAppointmentDto(appointment1);

    }

    @Override
    public AppointmentDto getAppointmentById(Long appId) {
        Appointment employee2= appointmentRepo.findById(appId)
                .orElseThrow(()->new ResourceNotFoundException("Appointment", "id" ,appId));
        return AppointmentMapper.mapToAppointmentDto(employee2);

    }

    @Override
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> employees =appointmentRepo.findAll();
        return employees.stream()
                .map((AppointmentMapper::mapToAppointmentDto))
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDto updateAppointment(Long appId, AppointmentDto updatedAppointment) {
        Appointment appointment=appointmentRepo.findById(appId)
                .orElseThrow(()->new ResourceNotFoundException("Appointment", "id" ,appId));
        appointment.setAvailableDate(updatedAppointment.getAvailableDate());
       appointment.setDoctorName(updatedAppointment.getDoctorName());
      appointment.setSpecialist(updatedAppointment.getSpecialist());
      appointment.setExperience(updatedAppointment.getExperience());


        Appointment updatedAppoints=appointmentRepo.save(appointment);
        return AppointmentMapper.mapToAppointmentDto(updatedAppoints);

    }

    @Override
    public void deleteAppointment(Long appId) {
        appointmentRepo.findById(appId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "id" ,appId));
        appointmentRepo.deleteById(appId);

    }

}



