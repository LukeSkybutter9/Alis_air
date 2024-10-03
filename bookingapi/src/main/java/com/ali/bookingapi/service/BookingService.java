package com.ali.bookingapi.service;


import com.ali.bookingapi.entities.Booking;

public interface BookingService {

    public Booking saveBooking(Booking booking);

    public Booking findBookingById(Long id);

    public Booking updateBooking(Long id, Booking bookingDetails);

    public void deleteBooking(Long id);


}
