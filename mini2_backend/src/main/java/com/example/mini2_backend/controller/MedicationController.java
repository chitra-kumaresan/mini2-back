package com.example.mini2_backend.controller;


import com.example.mini2_backend.dto.MedicationDto;
import com.example.mini2_backend.service.MedicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/medications")
@AllArgsConstructor
public class MedicationController {

    private MedicationService medicationService;
    @PostMapping("/saveMed")
    public ResponseEntity<MedicationDto> createDoctor(@RequestBody MedicationDto medicationDto){
        MedicationDto saved = medicationService.createMedication(medicationDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    //Build Get Medication REST API

    @GetMapping("{medId}")
    public ResponseEntity<MedicationDto> getMedicationById(@PathVariable("medId") Long medId){
        MedicationDto saved= medicationService.getMedicationById(medId);
        return ResponseEntity.ok(saved);

    }
    //Build Get All Medications REST API
    @GetMapping
    public ResponseEntity<List<MedicationDto>> getMedications(){
        List <MedicationDto> employeeDtoList=medicationService.getAllMedications();
        return ResponseEntity.ok(employeeDtoList);
    }
    //Build update Medication REST API
    @PutMapping("{medId}")
    public ResponseEntity<MedicationDto> updateMedications(@PathVariable("medId")Long medId,@RequestBody MedicationDto updated){
        MedicationDto updatedMeds=medicationService.updateMedication(medId,updated);
        return ResponseEntity.ok(updatedMeds);
    }
    //Build Delete Medication REST API
    @DeleteMapping("{medId}")
    public ResponseEntity<String> deleteMedications(@PathVariable("medId") Long medId) {
        medicationService.deleteMedication(medId);
        return ResponseEntity.ok("Medication deleted successfully");
    }
    //Build Get Medication REST API by Email

    @GetMapping("/email/{email}")
    public ResponseEntity<MedicationDto> getMedicationByEmailId(@PathVariable String email){
        MedicationDto saved= medicationService.getMedicationByEmail(email);
        return ResponseEntity.ok(saved);

    }
}
