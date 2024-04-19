package org.example.FlightAndPassenger.repository.impl;

import org.example.FlightAndPassenger.entity.Flight;
import org.example.FlightAndPassenger.mapper.FlightMapper;
import org.example.FlightAndPassenger.repository.FlightRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FlightRepositoryImpl implements FlightRepository {

    private static final FlightRepositoryImpl INSTANCE = new FlightRepositoryImpl() {
        @Override
        public void AddFlight(Flight flight) {

        }
    };

    private final FlightRepository flightRepository = FlightRepositoryImpl.getInstance();

    private final FlightMapper flightMapper = FlightMapper.getInstance();
    private static final Map<Long, Flight> flights = new HashMap<>();

    protected FlightRepositoryImpl() {}

    public static FlightRepositoryImpl getInstance() {
        return INSTANCE;
    }

    public void addFlight(Flight flight) {
        flights.put(flight.getNumber(), flight);

    }

    public abstract void AddFlight(Flight flight );

    @Override
    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights.values());
    }


}
