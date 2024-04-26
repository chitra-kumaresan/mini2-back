package com.example.mini2_backend.service;

import com.example.mini2_backend.dto.DoctorDto;
import com.example.mini2_backend.dto.MedicationDto;
import com.example.mini2_backend.entity.Doctor;
import com.example.mini2_backend.entity.Medication;
import com.example.mini2_backend.repo.DoctorRepo;
import com.example.mini2_backend.repo.MedicationRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
    public class MedicationServiceTest {


        @Mock
        private MedicationRepo medicationRepo;
        @InjectMocks
        private  MedicationServiceImpl medicationService;

        private Medication medication;
        @BeforeEach
        public void setUp(){
            medication=medication.builder()
                    .patientName("kishore")
                    .email("giri@gmail.com")
                    .appointmentDate(LocalDate.parse("2024-09-06"))
                    .medicationName("Dolo")
                    .morning("1")
                    .afternoon("1")
                    .night("1")
                    .doctorName("tarun")
                    .build();


        }
        @Test
        public void givenEmployeeList_whenGetAllEmployees_thenReturnEmployeeList(){
            Medication employee1=Medication.builder()
                    .patientName("kissan")
                    .email("kish@gmail.com")
                    .appointmentDate(LocalDate.parse("2024-09-06"))
                    .medicationName("Dolopo")
                    .morning("-")
                    .afternoon("1")
                    .night("1")
                    .doctorName("deepan")
                    .build();

            given(medicationRepo.findAll()).willReturn(List.of(medication,employee1));
            List<MedicationDto> employeeDtos=medicationService.getAllMedications();
            assertThat(employeeDtos).isNotNull();
            assertThat(employeeDtos.size()).isEqualTo(2);

        }
        @Test
        public void givenEmployee_whenGetEmployeesById_thenReturnEmployee(){

            given(medicationRepo.findById(medication.getMedId())).willReturn(Optional.of(medication));
            MedicationDto buss=medicationService.getMedicationById(medication.getMedId());
            assertThat(buss).isNotNull();


        }


    }
