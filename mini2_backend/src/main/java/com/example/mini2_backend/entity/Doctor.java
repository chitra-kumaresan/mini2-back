package com.example.mini2_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;

    @Column(nullable = false)
    @NotEmpty
    private String doctorName;

    @Column(nullable = false)
    @NotEmpty
    private String specialist;

    @Column(nullable = false)
    @NotEmpty
    private String experience;

    @Column(nullable = false)
    @NotEmpty
    private int age;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    @NotEmpty
    private Long contactNo;

}

