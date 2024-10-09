package com.ali.bookingapi.controller;

import com.ali.bookingapi.model.Flight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "flightsapi")
public interface FlightServiceClient {

    @GetMapping("/flight")
    Flight getFlightByFlightNumber(String flightNumber);
}
