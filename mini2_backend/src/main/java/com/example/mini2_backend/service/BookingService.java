package com.example.mini2_backend.service;

import com.example.mini2_backend.dto.AppointmentDto;
import com.example.mini2_backend.dto.BookingDto;
import com.example.mini2_backend.entity.Booking;

import java.util.List;

public interface BookingService {
    BookingDto createBooking(BookingDto bookingDto);
    BookingDto getBookingById(Long bookId);
    List<BookingDto> getAllBookings();
    BookingDto updateBooking(Long bookId,BookingDto updatedBooking);
    void deleteBooking(Long bookId);
     BookingDto getBookingsById(Long patId);

}
