package com.example.mini2_backend.repo;


import com.example.mini2_backend.entity.Appointment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

    @DataJpaTest
    public class AppointmentRepoTest {

        @Autowired
       private AppointmentRepo appointmentRepo;
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

@DisplayName("Test whether the appointment get saved in DB")
        @Test
        public void givenAppointment_whenSave_thenReturnSavedAppointment(){
            Appointment savedAppointment=appointmentRepo.save(appointment);
            assertThat(savedAppointment).isNotNull();
            assertThat(savedAppointment.getAppId()).isGreaterThan(0);
        }
        @Test
        public  void givenPassengerList_whenFindAll_thenPassengerList() {
            Appointment employee1 = Appointment.builder()
                    .availableDate(LocalDate.parse("2024-07-06"))
                    .doctorName("kumar")
                    .specialist("DIABETOLOGY")
                    .experience("10YRS")
                    .build();



            appointmentRepo.save(appointment);
            appointmentRepo.save(employee1);

            List<Appointment> passengerList = appointmentRepo.findAll();
            assertThat(passengerList).isNotNull();
            assertThat(passengerList.size()).isEqualTo(2);

        }
        @Test
        public  void givenAppointmentId_whenFindById_thenReturnAppointment(){
            appointmentRepo.save(appointment);
            Appointment passengerDb=appointmentRepo.findById(appointment.getAppId()).get();
            assertThat(passengerDb).isNotNull();

        }
        @Test
        public  void givenAppointment_whenUpdateAppointment_thenReturnUpdatedAppointment(){
            appointmentRepo.save(appointment);
            Appointment savedPassenger=appointmentRepo.findById(appointment.getAppId()).get();
            savedPassenger.setExperience("30yrs");
            Appointment updatedPassenger=appointmentRepo.save(savedPassenger);
            assertThat(updatedPassenger.getExperience()).isEqualTo("30yrs");
        }
        @Test
        public  void givenAppointment_whenDelete_thenRemoveAppointment(){
            appointmentRepo.save(appointment);
            appointmentRepo.deleteById(appointment.getAppId());
            Optional<Appointment> passenger1=appointmentRepo.findById(appointment.getAppId());
            assertThat(passenger1).isEmpty();

        }
    }


