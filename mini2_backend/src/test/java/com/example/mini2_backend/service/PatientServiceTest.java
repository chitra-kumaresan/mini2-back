package com.example.mini2_backend.service;


import com.example.mini2_backend.dto.PatientDto;
import com.example.mini2_backend.entity.Patient;
import com.example.mini2_backend.repo.PatientRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
    public class PatientServiceTest {


        @Mock
        private PatientRepo patientRepo;
        @InjectMocks
        private PatientServiceImpl patientService;

        private Patient patient;

        @BeforeEach
        public void setUp() {
            patient = patient.builder()
                    .patientName("rithanika")
                    .email("chith@gmail.com")
                    .problem("stomachache")
                    .contactNo(8765432345L)
                    .age(45)
                    .build();
        }

        @Test
        public void givenEmployeeList_whenGetAllEmployees_thenReturnEmployeeList() {
            Patient employee1 = Patient.builder()
                    .patientName("rithanika")
                    .email("chithra@gmail.com")
                    .problem("stomachache")
                    .contactNo(8765432345L)
                    .age(45)
                    .build();


            given(patientRepo.findAll()).willReturn(List.of(patient,employee1));
            List<PatientDto> employeeDtos = patientService.getAllPatients();
            assertThat(employeeDtos).isNotNull();
            assertThat(employeeDtos.size()).isEqualTo(2);

        }

        @Test
        public void givenEmployee_whenGetEmployeesById_thenReturnEmployee() {

            given(patientRepo.findById(patient.getPatId())).willReturn(Optional.of(patient));
            PatientDto buss = patientService.getPatientById(patient.getPatId());
            assertThat(buss).isNotNull();
        }


    }
