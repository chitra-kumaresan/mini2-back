package com.example.mini2_backend.service;


import com.example.mini2_backend.dto.AppointmentDto;
import com.example.mini2_backend.entity.Appointment;
import com.example.mini2_backend.repo.AppointmentRepo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;



    @ExtendWith(MockitoExtension.class)
    public class AppointmentServiceTest {


        @Mock
        private AppointmentRepo appointmentRepo;
        @InjectMocks
        private  AppointmentServiceImpl appointmentService;

        private Appointment appointment;
        @BeforeEach
        public void setUp(){
            appointment=Appointment.builder()
                    .availableDate(LocalDate.parse("2024-09-06"))
                    .doctorName("CHITRA")
                    .specialist("DIABETOLOGY")
                    .experience("10YRS")
                    .build();

        }
        @Test
        public void givenEmployeeList_whenGetAllEmployees_thenReturnEmployeeList(){
            Appointment employee1=Appointment.builder()
                    .availableDate(LocalDate.parse("2024-09-06"))
                    .doctorName("kumaresan")
                    .specialist("DIABETOLOGY")
                    .experience("10YRS")
                    .build();


            given(appointmentRepo.findAll()).willReturn(List.of(appointment,employee1));
            List<AppointmentDto> employeeDtos=appointmentService.getAllAppointments();
            assertThat(employeeDtos).isNotNull();
            assertThat(employeeDtos.size()).isEqualTo(2);

        }
        @Test
        public void givenEmployee_whenGetEmployeesById_thenReturnEmployee(){

            given(appointmentRepo.findById(appointment.getAppId())).willReturn(Optional.of(appointment));
            AppointmentDto buss=appointmentService.getAppointmentById(appointment.getAppId());
            assertThat(buss).isNotNull();


        }


    }
