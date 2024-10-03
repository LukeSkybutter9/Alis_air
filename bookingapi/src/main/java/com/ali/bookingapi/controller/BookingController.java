package com.ali.bookingapi.controller;

import com.ali.bookingapi.entities.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ali.bookingapi.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking bookingEntity) {
        return ResponseEntity.ok(bookingService.saveBooking(bookingEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.findBookingById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingEntity) {
        return ResponseEntity.ok(bookingService.updateBooking(id, bookingEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return null;
    }

}
