package com.ali.bookingapi.repository;

import com.ali.bookingapi.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRespository extends JpaRepository<Booking,Long> {
}
