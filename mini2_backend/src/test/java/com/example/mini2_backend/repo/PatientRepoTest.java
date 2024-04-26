package com.example.mini2_backend.repo;

import com.example.mini2_backend.entity.Doctor;
import com.example.mini2_backend.entity.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

    @DataJpaTest
    public class PatientRepoTest {

        @Autowired
        private PatientRepo patientRepo;
        private Patient patient;


        @BeforeEach
        public void setUp(){
            patient=Patient.builder()
                    .patientName("rithanika")
                    .email("chithra@gmail.com")
                    .problem("stomachache")
                    .contactNo(8765432345L)
                    .age(45)
                    .build();
        }

        @DisplayName("Test whether the patient get saved in DB")
        @Test
        public void givenEmployee_whenSave_thenReturnSavedEmployee(){
            Patient savedDoctor =patientRepo.save(patient);
            assertThat(savedDoctor ).isNotNull();
            assertThat(savedDoctor.getPatId()).isGreaterThan(0);


        }
        @Test
        public  void givenPassengerList_whenFindAll_thenPassengerList() {
            Patient  employee1 = Patient.builder()
                    .patientName("rithan")
                    .email("chith@gmail.com")
                    .problem("stomachache")
                    .contactNo(8765432345L)
                    .age(45)
                    .build();

            patientRepo.save(patient);
            patientRepo.save(employee1);

            List<Patient> passengerList = patientRepo.findAll();
            assertThat(passengerList).isNotNull();
            assertThat(passengerList.size()).isEqualTo(2);

        }
        @Test
        public  void givenEmployeeEmail_whenFindByEmail_thenReturnEmployee(){
            patientRepo.save(patient);
            Optional<Patient> passengerDb= Optional.of(patientRepo.findById(patient.getPatId()).get());
            assertThat(passengerDb).isNotNull();

        }
        @Test
        public  void givenPassenger_whenUpdatePassenger_thenReturnUpdatedPassenger(){
            patientRepo.save(patient);
            Patient savedPassenger=patientRepo.findById(patient.getPatId()).get();
            savedPassenger.setEmail("kumar@gmail.com");
            Patient updatedPassenger=patientRepo.save(savedPassenger);
            assertThat(updatedPassenger.getEmail()).isEqualTo("kumar@gmail.com");
        }
        @Test
        public  void givenEmployee_whenDelete_thenRemoveEmployee(){
            patientRepo.save(patient);
            patientRepo.deleteById(patient.getPatId());
            Optional<Patient> passenger1=patientRepo.findById(patient.getPatId());
            assertThat(passenger1).isEmpty();

        }
    }
