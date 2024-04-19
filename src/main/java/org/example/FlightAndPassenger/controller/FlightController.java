package org.example.FlightAndPassenger.controller;

import org.example.FlightAndPassenger.dto.request.AddFlightRequest;
import org.example.FlightAndPassenger.dto.response.GetFlightResponse;
import org.example.FlightAndPassenger.service.FlightService;
import org.example.FlightAndPassenger.service.impl.FlightServiceImpl;


import java.util.List;

public class FlightController {

    private static final FlightController INSTANCE = new FlightController();
    private final FlightService flightService = FlightServiceImpl.getInstance();

    private FlightController() {}

    public static FlightController getInstance() {
        return INSTANCE;
    }

    public void addFlight(AddFlightRequest request) {flightService.addFlight(request);
    }

    public List<GetFlightResponse> getAllFlights() {
        return flightService.getAllFlights();
    }

}