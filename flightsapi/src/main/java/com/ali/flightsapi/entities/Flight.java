package com.ali.flightsapi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "flight")
@Data

public class Flight {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;

}
