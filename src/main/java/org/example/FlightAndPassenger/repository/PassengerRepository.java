package org.example.FlightAndPassenger.repository;

import org.example.FlightAndPassenger.entity.Passenger;

import java.util.List;

public interface PassengerRepository {
    // A -> B

    void addPassenger(Passenger passenger);
    List<Passenger> getAllPassengers();

}