package com.ali.flightsapi.service;

import com.ali.flightsapi.entities.Flight;

public interface FlightService {

    public Flight saveFlight(Flight flight);

    public Flight findFlightByFlightNumber (String flightNumber);

    public Flight findFlightById(Long id);

    public Flight updateFlight(Long id, Flight flightDetails);

    public void deleteFlight(Long id);

}
