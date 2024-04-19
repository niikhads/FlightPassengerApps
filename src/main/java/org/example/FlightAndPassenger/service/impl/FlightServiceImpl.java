package org.example.FlightAndPassenger.service.impl;

import org.example.FlightAndPassenger.mapper.FlightMapper;
import org.example.FlightAndPassenger.service.FlightService;
import org.example.FlightAndPassenger.repository.FlightRepository;
import org.example.FlightAndPassenger.repository.impl.FlightRepositoryImpl;
import org.example.FlightAndPassenger.util.IdAndNumberGeneratorUtil;
import org.example.FlightAndPassenger.dto.request.AddFlightRequest;
import org.example.FlightAndPassenger.dto.response.GetFlightResponse;
import org.example.FlightAndPassenger.entity.Flight;

import java.util.List;

public class FlightServiceImpl implements FlightService {

    private static final FlightServiceImpl INSTANCE = new FlightServiceImpl();
    //private final FlightRepository flightRepository = FlightMySqlRepositoryImpl.getInstance();
    private final FlightRepository flightRepository = FlightRepositoryImpl.getInstance();
    private final FlightMapper flightMapper = FlightMapper.getInstance();

    private FlightServiceImpl() {
    }

    public static FlightServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void addFlight(AddFlightRequest request) {
        Flight flight = flightMapper.toFlight(request);
        flight.setNumber(IdAndNumberGeneratorUtil.getNewFlightNumber());

        FlightRepositoryImpl.getInstance().addFlight(flight);
    }

    @Override
    public List<GetFlightResponse> getAllFlights() {
        List<Flight> flights = flightRepository.getAllFlights();
        return flightMapper.toGetFlightResponseList(flights);
    }
}


