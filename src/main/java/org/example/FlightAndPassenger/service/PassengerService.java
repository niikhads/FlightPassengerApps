package org.example.FlightAndPassenger.service;

import org.example.FlightAndPassenger.dto.request.AddPassengerRequest;
import org.example.FlightAndPassenger.dto.response.GetPassengerResponse;

import java.util.List;

public interface PassengerService {

    void addPassenger(AddPassengerRequest request);
    List<GetPassengerResponse> getAllPassengers();

}