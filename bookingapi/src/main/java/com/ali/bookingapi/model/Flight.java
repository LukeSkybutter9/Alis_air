package com.ali.bookingapi.model;


import lombok.Data;

@Data

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
}
