package com.ali.bookingapi.controller;

import com.ali.bookingapi.model.Flight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "flightsapi")
public interface FlightServiceClient {

    @GetMapping("/flights/map/{flightNumber}")
    Flight getFlightByFlightNumber(@PathVariable String flightNumber);
}
