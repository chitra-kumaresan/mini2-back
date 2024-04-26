package com.example.mini2_backend.repo;

import com.example.mini2_backend.entity.Booking;
import com.example.mini2_backend.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,Long> {

    Booking getById(Long patId);

}
