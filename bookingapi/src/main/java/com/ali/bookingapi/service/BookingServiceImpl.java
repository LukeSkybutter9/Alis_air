package com.ali.bookingapi.service;

import com.ali.bookingapi.entities.Booking;
import org.springframework.stereotype.Service;
import com.ali.bookingapi.repository.BookingRespository;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRespository bookingRespository;

    public BookingServiceImpl(BookingRespository bookingRespository) {
        this.bookingRespository = bookingRespository;
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRespository.save(booking);
    }

    @Override
    public Booking findBookingById(Long id) {
        return bookingRespository.findById(id).orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
    }

    @Override
    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingRespository.findById(id).orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
        booking.setId(bookingDetails.getId());
        booking.setFlightNumber(bookingDetails.getFlightNumber());
        return bookingRespository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        Booking booking = bookingRespository.findById(id).orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
        bookingRespository.delete(booking);
    }
}
