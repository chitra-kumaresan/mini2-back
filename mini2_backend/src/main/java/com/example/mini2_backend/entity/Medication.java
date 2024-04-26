package com.example.mini2_backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="medications")
@Entity
public class Medication {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long medId;
        @NotEmpty
        private String patientName;
        @Email
        private String email;
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
        private LocalDate appointmentDate;
        @NotEmpty
        private String medicationName;
        @NotEmpty
        private String morning;
        @NotEmpty
        private String afternoon;
        @NotEmpty
        private String night;

        @Column(nullable = false)
        @NotEmpty
        private String doctorName;


}

