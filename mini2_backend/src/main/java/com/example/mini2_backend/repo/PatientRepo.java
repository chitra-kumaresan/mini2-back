package com.example.mini2_backend.repo;

import com.example.mini2_backend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Long> {

}
