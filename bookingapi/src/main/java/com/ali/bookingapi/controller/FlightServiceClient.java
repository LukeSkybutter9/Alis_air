package com.ali.bookingapi.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "flightsapi")
public interface FlightServiceClient {

    @GetMapping("/flight/{id}")
    String getFlight(@PathVariable("id") String id);
}
