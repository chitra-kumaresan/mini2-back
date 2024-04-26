package com.example.mini2_backend.controller;

import com.example.mini2_backend.dto.AppointmentDto;

import com.example.mini2_backend.service.AppointmentService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/appointments")
@AllArgsConstructor
public class AppointmentController {
    private AppointmentService appointmentService;
    //Build Add  REST API
    @PostMapping("/saveApp")
    public ResponseEntity<AppointmentDto> createDoctor(@RequestBody AppointmentDto appointmentDto){
        AppointmentDto created = appointmentService.createAppointment(appointmentDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    //Build Get Appointment REST API

    @GetMapping("{appId}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable("appId") Long appId){
        AppointmentDto saved= appointmentService.getAppointmentById(appId);
        return ResponseEntity.ok(saved);

    }
    //Build Get All Appointments REST API
    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAppointments(){
        List <AppointmentDto> employeeDtoList=appointmentService.getAllAppointments();
        return ResponseEntity.ok(employeeDtoList);
    }
    //Build update Appointment REST API
    @PutMapping("{appId}")
    public ResponseEntity<AppointmentDto> updateDoctor(@PathVariable("appId")Long appId,@RequestBody AppointmentDto updated){
        AppointmentDto update=appointmentService.updateAppointment(appId,updated);
        return ResponseEntity.ok(update);
    }
    //Build Delete Appointment REST API
    @DeleteMapping("{appId}")
    public ResponseEntity<String> deleteAppointments(@PathVariable("appId") Long appId) {
        appointmentService.deleteAppointment(appId);
        return ResponseEntity.ok("Appointment deleted successfully");
    }




}
