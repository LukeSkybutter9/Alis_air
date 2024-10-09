package com.ali.flightsapi.controller;

import com.ali.flightsapi.entities.Flight;
import com.ali.flightsapi.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.saveFlight(flight));
    }

    @GetMapping
    public ResponseEntity<Flight> findFlightByFlightNumber(String flightNumber) {
        return ResponseEntity.ok(flightService.findFlightByFlightNumber(flightNumber));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> findFlightById(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.findFlightById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.updateFlight(id, flight));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return null;
    }
}
