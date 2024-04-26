package com.example.mini2_backend.dto;


import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private Long docId;
    private String doctorName;
    private String specialist;
    private  String experience;
    private int age;
    private String email;
    private Long contactNo;

}
