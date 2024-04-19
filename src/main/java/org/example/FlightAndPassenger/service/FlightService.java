package org.example.FlightAndPassenger.service;

import org.example.FlightAndPassenger.dto.request.AddFlightRequest;
import org.example.FlightAndPassenger.dto.response.GetFlightResponse;

import java.util.List;

public interface FlightService {

    void addFlight(AddFlightRequest request);
    List<GetFlightResponse> getAllFlights();

}