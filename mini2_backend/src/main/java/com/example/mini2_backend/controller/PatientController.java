package com.example.mini2_backend.controller;
import com.example.mini2_backend.dto.PatientDto;

import com.example.mini2_backend.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientController {


        private PatientService patientService;
        //Build Add Patient REST API

        @PostMapping("/savePatient")
        public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto){
            PatientDto savedEmployee = patientService.createPatient(patientDto);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        }
        //Build Get Patient REST API

        @GetMapping("{patId}")
        public ResponseEntity<PatientDto> getPatientsById(@PathVariable("patId") Long patId){
            PatientDto savedEmployee= patientService.getPatientById(patId);
            return ResponseEntity.ok(savedEmployee);

        }
        //Build Get All Patients REST API
        @GetMapping
        public ResponseEntity<List<PatientDto>> getPatients(){
            List <PatientDto> employeeDtoList=patientService.getAllPatients();
            return ResponseEntity.ok(employeeDtoList);
        }
        //Build update Patient REST API
        @PutMapping("{patId}")
        public ResponseEntity<PatientDto> updatePatient(@PathVariable("patId")Long patId,@RequestBody PatientDto updatedPatient){
            PatientDto updatedEmployees=patientService.updatePatient(patId,updatedPatient);
            return ResponseEntity.ok(updatedEmployees);
        }
        //Build Delete Patient REST API
        @DeleteMapping("{patId}")
        public ResponseEntity<String> deletePatients(@PathVariable("patId") Long patId) {
            patientService.deletePatient(patId);
            return ResponseEntity.ok("Patient deleted successfully");
        }


    }
