package com.example.mini2_backend.repo;

import com.example.mini2_backend.entity.Doctor;
import com.example.mini2_backend.entity.Medication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

    @DataJpaTest
    public class MedicationRepoTest {

        @Autowired
        private MedicationRepo medicationRepo;
        private Medication medication;


        @BeforeEach
        public void setUp(){
          medication=Medication.builder()
                  .patientName("kishore")
                  .email("girish@gmail.com")
                  .appointmentDate(LocalDate.parse("2024-09-06"))
                  .medicationName("Dolo")
                  .morning("1")
                  .afternoon("1")
                  .night("1")
                  .doctorName("tarun")
                  .build();
        }

        @DisplayName("Test whether the passenger get saved in DB")
        @Test
        public void givenEmployee_whenSave_thenReturnSavedEmployee(){
            Medication savedDoctor =medicationRepo.save(medication);
            assertThat(savedDoctor ).isNotNull();
            assertThat(savedDoctor.getMedId()).isGreaterThan(0);


        }
        @Test
        public  void givenPassengerList_whenFindAll_thenPassengerList() {
            Medication employee1 = Medication.builder()
                    .patientName("kisan")
                    .email("giri@gmail.com")
                    .appointmentDate(LocalDate.parse("2024-09-06"))
                    .medicationName("Dolo")
                    .morning("1")
                    .afternoon("1")
                    .night("1")
                    .doctorName("tarun")
                    .build();


            medicationRepo.save(medication);
            medicationRepo.save(employee1);

            List<Medication> passengerList = medicationRepo.findAll();
            assertThat(passengerList).isNotNull();
            assertThat(passengerList.size()).isEqualTo(2);

        }
        @Test
        public  void givenEmployeeEmail_whenFindByEmail_thenReturnEmployee(){
            medicationRepo.save(medication);
            Optional<Medication> passengerDb= Optional.of(medicationRepo.findById(medication.getMedId()).get());
            assertThat(passengerDb).isNotNull();

        }
        @Test
        public  void givenPassenger_whenUpdatePassenger_thenReturnUpdatedPassenger(){
            medicationRepo.save(medication);
            Medication savedPassenger=medicationRepo.findById(medication.getMedId()).get();
            savedPassenger.setEmail("kumar@gmail.com");
            Medication updatedPassenger=medicationRepo.save(savedPassenger);
            assertThat(updatedPassenger.getEmail()).isEqualTo("kumar@gmail.com");
        }
        @Test
        public  void givenEmployee_whenDelete_thenRemoveEmployee(){
            medicationRepo.save(medication);
            medicationRepo.deleteById(medication.getMedId());
            Optional<Medication> passenger1=medicationRepo.findById(medication.getMedId());
            assertThat(passenger1).isEmpty();

        }



    }

