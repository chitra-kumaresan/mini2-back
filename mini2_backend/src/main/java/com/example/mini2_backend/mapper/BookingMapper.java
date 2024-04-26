package com.example.mini2_backend.mapper;

import com.example.mini2_backend.dto.AppointmentDto;
import com.example.mini2_backend.dto.BookingDto;
import com.example.mini2_backend.entity.Appointment;
import com.example.mini2_backend.entity.Booking;
import com.example.mini2_backend.entity.Patient;

import java.time.LocalDate;

public class BookingMapper {
    public static BookingDto mapToBookingDto(Booking booking) {
        return new BookingDto(
                booking.getBookId(),
                booking.getDoctorName(),
                booking.getPatient(),

                booking.getAppointmentDate()


        );
    }
    public static Booking mapToBooking(BookingDto bookingDto) {
        return new Booking(
                bookingDto.getBookId(),
                bookingDto.getDoctorName(),
                bookingDto.getPatient(),
                bookingDto.getAppointmentDate()
        );
    }

}
