package com.ali.bookingapi.service;

import com.ali.bookingapi.controller.FlightServiceClient;
import com.ali.bookingapi.entities.Booking;
import com.ali.bookingapi.model.Flight;
import org.springframework.stereotype.Service;
import com.ali.bookingapi.repository.BookingRespository;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRespository bookingRespository;
    private final FlightServiceClient flightServiceClient;

    public BookingServiceImpl(BookingRespository bookingRespository, FlightServiceClient flightServiceClient) {
        this.bookingRespository = bookingRespository;
        this.flightServiceClient = flightServiceClient;
    }

    @Override
    public Booking saveBooking(Booking booking) {

        Flight flight = flightServiceClient.getFlightByFlightNumber(booking.getFlightNumber());

        if (flight == null) {
            throw new RuntimeException("Vuelo no encontrado");
        }

        booking.setFlightNumber(flight.getFlightNumber());

        return bookingRespository.save(booking);
    }

    @Override
    public Booking findBookingById(Long id) {
        return bookingRespository.findById(id).orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
    }

    @Override
    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingRespository.findById(id).orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
        Flight flight = flightServiceClient.getFlightByFlightNumber(booking.getFlightNumber());

        if (flight == null) {
            throw new RuntimeException("Vuelo no encontrado");
        }

        booking.setFlightNumber(flight.getFlightNumber());
        booking.setId(bookingDetails.getId());
        booking.setPassengerName(bookingDetails.getPassengerName());
        return bookingRespository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        Booking booking = bookingRespository.findById(id).orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
        bookingRespository.delete(booking);
    }
}
