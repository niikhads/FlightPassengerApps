package org.example.FlightAndPassenger.repository.impl;

import org.example.FlightAndPassenger.repository.PassengerRepository;
import org.example.FlightAndPassenger.entity.Passenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassengerRepositoryImpl implements PassengerRepository {

    private static final PassengerRepositoryImpl INSTANCE = new PassengerRepositoryImpl();
    private static final Map<Long, Passenger> passengers = new HashMap<>(); // databaza

    PassengerRepositoryImpl() {}

    public static PassengerRepositoryImpl getInstance() {
        return INSTANCE;
    }

    public void addPassenger (Passenger passenger) {
        passengers.put(passenger.getId(), passenger);
    }

 //   public abstract void AddPassenger(Passenger passenger);

   // public abstract void AddPassenger(Passenger passenger);

    public List<Passenger> getAllPassengers() {
        return new ArrayList<>(passengers.values());
    }

}