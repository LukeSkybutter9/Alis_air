package com.ali.flightsapi.service;

import com.ali.flightsapi.entities.Flight;
import com.ali.flightsapi.repository.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight findFlightById(Long id) {
        return flightRepository.findById(id).orElseThrow(()-> new RuntimeException("Vuelo no encontrado"));
    }

    @Override
    public Flight updateFlight(Long id, Flight flightDetails) {
        Flight flight = flightRepository.findById(id).orElseThrow(()-> new RuntimeException("Vuelo no encontrado"));
        flight.setId(id);
        flight.setFlightNumber(flightDetails.getFlightNumber());
        flight.setDestination(flightDetails.getDestination());
        flight.setDepartureTime(flightDetails.getDepartureTime());
        flight.setOrigin(flightDetails.getOrigin());
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(()-> new RuntimeException("Vuelo no encontrado"));
        flightRepository.delete(flight);
    }
}
