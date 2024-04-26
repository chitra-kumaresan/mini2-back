package com.example.mini2_backend.repo;


import com.example.mini2_backend.entity.Doctor;
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
    public class DoctorRepoTest {

        @Autowired
        private DoctorRepo doctorRepo;
        private Doctor doctor;


        @BeforeEach
        public void setUp(){
            doctor=Doctor.builder()
                    .doctorName("CHITRA")
                    .specialist("DIABETIST")
                    .experience("10YRS")
                    .age(35)
                    .email("CHITRAP@gmail.com")
                    .contactNo(7654321789L)
                    .build();
        }

        @DisplayName("Test whether the passenger get saved in DB")
        @Test
        public void givenEmployee_whenSave_thenReturnSavedEmployee(){
            Doctor savedDoctor =doctorRepo.save(doctor );
            assertThat(savedDoctor ).isNotNull();
            assertThat(savedDoctor.getDocId()).isGreaterThan(0);


        }
        @Test
        public  void givenPassengerList_whenFindAll_thenPassengerList() {
            Doctor  employee1 = Doctor .builder()
                    .doctorName("CHITRA")
                    .specialist("DIABETIST")
                    .experience("10YRS")
                    .age(35)
                    .email("CHITRA@gmail.com")
                    .contactNo(7654321789L)
                    .build();


            doctorRepo.save(doctor);
            doctorRepo.save(employee1);

            List<Doctor> passengerList = doctorRepo.findAll();
            assertThat(passengerList).isNotNull();
            assertThat(passengerList.size()).isEqualTo(2);

        }
        @Test
        public  void givenEmployeeEmail_whenFindByEmail_thenReturnEmployee(){
            doctorRepo.save(doctor);
            Optional<Doctor> passengerDb= Optional.of(doctorRepo.findById(doctor.getDocId()).get());
            assertThat(passengerDb).isNotNull();

        }
        @Test
        public  void givenPassenger_whenUpdatePassenger_thenReturnUpdatedPassenger(){
            doctorRepo.save(doctor);
            Doctor savedPassenger=doctorRepo.findById(doctor.getDocId()).get();
            savedPassenger.setEmail("kumar@gmail.com");
            Doctor updatedPassenger=doctorRepo.save(savedPassenger);
            assertThat(updatedPassenger.getEmail()).isEqualTo("kumar@gmail.com");
        }
        @Test
        public  void givenEmployee_whenDelete_thenRemoveEmployee(){
            doctorRepo.save(doctor);
            doctorRepo.deleteById(doctor.getDocId());
            Optional<Doctor> passenger1=doctorRepo.findById(doctor.getDocId());
            assertThat(passenger1).isEmpty();

        }
    }


