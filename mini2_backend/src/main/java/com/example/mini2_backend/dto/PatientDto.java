package com.example.mini2_backend.dto;

import com.example.mini2_backend.entity.Booking;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private Long patId;
    private String patientName;
    private String email;
    private String problem;
    private Long contactNo;
    private int age;


}
