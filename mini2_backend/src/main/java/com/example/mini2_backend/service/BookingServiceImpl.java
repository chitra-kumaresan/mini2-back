package com.example.mini2_backend.service;

import com.example.mini2_backend.dto.BookingDto;
import com.example.mini2_backend.entity.Appointment;
import com.example.mini2_backend.entity.Booking;
import com.example.mini2_backend.entity.Patient;
import com.example.mini2_backend.exception.ResourceNotFoundException;
import com.example.mini2_backend.mapper.AppointmentMapper;
import com.example.mini2_backend.mapper.BookingMapper;
import com.example.mini2_backend.repo.BookingRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService{

    private BookingRepo bookingRepo;
    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        Booking booking= BookingMapper.mapToBooking(bookingDto);
        Booking appointment1 =bookingRepo.save(booking);
        return BookingMapper.mapToBookingDto(appointment1);
    }

    @Override
    public BookingDto getBookingById(Long bookId) {
        Booking employee2= bookingRepo.findById(bookId)
                .orElseThrow(()->new ResourceNotFoundException("Booking", "id" ,bookId));
        return BookingMapper.mapToBookingDto(employee2);

    }

    @Override
    public List<BookingDto> getAllBookings() {
        List<Booking> employees =bookingRepo.findAll();
        return employees.stream()
                .map((BookingMapper::mapToBookingDto))
                .collect(Collectors.toList());

    }


    @Override
    public BookingDto updateBooking(Long bookId, BookingDto updatedBooking) {
        Booking booking=bookingRepo.findById(bookId)
                .orElseThrow(()->new ResourceNotFoundException("Booking", "id" ,bookId));
      booking.setDoctorName(updatedBooking.getDoctorName());
      booking.setPatient(updatedBooking.getPatient());
      booking.setAppointmentDate(updatedBooking.getAppointmentDate());
      Booking updatedAppoints=bookingRepo.save(booking);
        return BookingMapper.mapToBookingDto(updatedAppoints);

    }

    @Override
    public void deleteBooking(Long bookId) {
        bookingRepo.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking", "id" ,bookId));
        bookingRepo.deleteById(bookId);


    }

    @Override
    public BookingDto getBookingsById(Long patId) {
        Booking booking=bookingRepo.getById(patId);
        return BookingMapper.mapToBookingDto(booking);
    }


}
