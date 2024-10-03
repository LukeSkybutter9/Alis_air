package com.ali.bookingapi.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "booking")
@Data

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String flightNumber;
    private String passengerName;

}
