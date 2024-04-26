package com.example.mini2_backend.controller;

import com.example.mini2_backend.dto.DoctorDto;
import com.example.mini2_backend.entity.Doctor;
import com.example.mini2_backend.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/doctors")
@AllArgsConstructor
public class DoctorController {

    private DoctorService doctorService;
    //Build Add Doctor REST API

    @PostMapping("/saveDoctor")
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto savedEmployee = doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //Build Get Doctor REST API

    @GetMapping("{docId}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable("docId") Long docId){
        DoctorDto savedEmployee= doctorService.getDoctorById(docId);
        return ResponseEntity.ok(savedEmployee);

    }
    //Build Get All Doctors REST API
    @GetMapping
    public ResponseEntity<List<DoctorDto>> getDoctors(){
        List <DoctorDto> employeeDtoList=doctorService.getAllDoctors();
        return ResponseEntity.ok(employeeDtoList);
    }
    //Build update Doctor REST API
    @PutMapping("{docId}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable("docId")Long docId,@RequestBody DoctorDto updatedDoctor){
        DoctorDto updatedEmployees=doctorService.updateDoctor(docId,updatedDoctor);
        return ResponseEntity.ok(updatedEmployees);
    }
    //Build Delete Doctor REST API
    @DeleteMapping("{docId}")
    public ResponseEntity<String> deleteDoctors(@PathVariable("docId") Long docId) {
        doctorService.deleteDoctor(docId);
        return ResponseEntity.ok("Doctor deleted successfully");
    }


}
