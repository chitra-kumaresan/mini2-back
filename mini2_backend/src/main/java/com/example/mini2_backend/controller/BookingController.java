package com.example.mini2_backend.controller;

import com.example.mini2_backend.dto.BookingDto;
import com.example.mini2_backend.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/bookings")
@AllArgsConstructor

public class BookingController {
    private BookingService bookingService;
    //Build Add  REST API
    @PostMapping("/saveBook")
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto){
        BookingDto created =bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    //Build Get Booking REST API

    @GetMapping("{bookId}")
    public ResponseEntity<BookingDto> getBookingsById(@PathVariable("bookId") Long bookId){
        BookingDto saved= bookingService.getBookingById(bookId);
        return ResponseEntity.ok(saved);

    }

    //Build Get Booking REST API
    @GetMapping("patId/{patId}")
    public ResponseEntity<BookingDto> getBookingByPatientId(@PathVariable Long patId){
        BookingDto saved1= bookingService.getBookingsById(patId);
        return ResponseEntity.ok(saved1);

    }
    //Build Get All Bookings REST API
    @GetMapping
    public ResponseEntity<List<BookingDto>> getBookings(){
        List <BookingDto> employeeDtoList=bookingService.getAllBookings();
        return ResponseEntity.ok(employeeDtoList);
    }
    //Build update Booking REST API
    @PutMapping("{bookId}")
    public ResponseEntity<BookingDto> updateBookings(@PathVariable("bookId")Long bookId,@RequestBody BookingDto updated){
        BookingDto update=bookingService.updateBooking(bookId,updated);
        return ResponseEntity.ok(update);
    }
    //Build Delete Booking REST API
    @DeleteMapping("{bookId}")
    public ResponseEntity<String> deleteBookings(@PathVariable("bookId") Long bookId) {
        bookingService.deleteBooking(bookId);
        return ResponseEntity.ok("Booking deleted successfully");
    }


}
