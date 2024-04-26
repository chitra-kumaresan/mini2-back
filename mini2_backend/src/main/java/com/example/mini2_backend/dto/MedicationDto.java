package com.example.mini2_backend.dto;

import com.example.mini2_backend.entity.Doctor;
import com.example.mini2_backend.entity.Patient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicationDto {

    private Long medId;
    private String patientName;
    private String email;
    private LocalDate appointmentDate;
    private String medicationName;
    private String morning;
    private String afternoon;
    private String night;
    private String doctorName;

}
