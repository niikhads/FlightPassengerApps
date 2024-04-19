package org.example.FlightAndPassenger.repository;

import org.example.FlightAndPassenger.entity.Flight;

import java.util.List;

public interface FlightRepository {
    // A -> B

    void addFlight(Flight flight);
    List<Flight> getAllFlights();

}