package com.ali.flightsapi.repository;

import com.ali.flightsapi.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
