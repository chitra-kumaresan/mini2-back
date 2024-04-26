package com.example.mini2_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor

@NoArgsConstructor
@Table(name="patients")
@Entity
public class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long patId;
        @Column(nullable = false)
        @NotEmpty
        private String patientName;

        @Column(nullable = false,unique = true)
        @NotEmpty
        @Email
        private String email;

        @Column(nullable = false)
        @NotEmpty
        private String problem;

        @Column(nullable = false)
        @NotEmpty
        private Long contactNo;

        @Column(nullable = false)
        @NotEmpty
        private int age;


    }

