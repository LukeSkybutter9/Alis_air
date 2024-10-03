package com.ali.bookingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookingapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingapiApplication.class, args);
	}

}
