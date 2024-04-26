package com.example.mini2_backend.repo;

import com.example.mini2_backend.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepo extends JpaRepository<Medication,Long> {
    Medication findByEmail(String email);
}
