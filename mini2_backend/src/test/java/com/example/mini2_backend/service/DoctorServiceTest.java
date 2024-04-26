package com.example.mini2_backend.service;


import com.example.mini2_backend.dto.DoctorDto;
import com.example.mini2_backend.entity.Doctor;
import com.example.mini2_backend.repo.DoctorRepo;
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
    public class DoctorServiceTest {


        @Mock
        private DoctorRepo doctorRepo;
        @InjectMocks
        private  DoctorServiceImpl doctorService;

        private Doctor doctor;
        @BeforeEach
        public void setUp(){
            doctor=doctor.builder()
                    .doctorName("CHITRA")
                    .specialist("DIABETIST")
                    .experience("10YRS")
                    .age(35)
                    .email("CHITRA@gmail.com")
                    .contactNo(7654321789L)
                    .build();

        }
        @Test
        public void givenEmployeeList_whenGetAllEmployees_thenReturnEmployeeList(){
            Doctor employee1=Doctor.builder()
                    .doctorName("KUMAR")
                    .specialist("DIABETIST")
                    .experience("10YRS")
                    .age(24)
                    .email("CHITRA@gmail.com")
                    .contactNo(7654321789L)
                    .build();



            given(doctorRepo.findAll()).willReturn(List.of(doctor,employee1));
            List<DoctorDto> employeeDtos=doctorService.getAllDoctors();
            assertThat(employeeDtos).isNotNull();
            assertThat(employeeDtos.size()).isEqualTo(2);

        }
        @Test
        public void givenEmployee_whenGetEmployeesById_thenReturnEmployee(){

            given(doctorRepo.findById(doctor.getDocId())).willReturn(Optional.of(doctor));
            DoctorDto buss=doctorService.getDoctorById(doctor.getDocId());
            assertThat(buss).isNotNull();


        }


    }
