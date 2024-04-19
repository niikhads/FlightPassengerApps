package org.example.FlightAndPassenger.controller;

import org.example.FlightAndPassenger.dto.request.AddPassengerRequest;
import org.example.FlightAndPassenger.dto.response.GetPassengerResponse;
import org.example.FlightAndPassenger.service.PassengerService;
import org.example.FlightAndPassenger.service.impl.PassengerServiceImpl;

import java.util.List;

public class  PassengerController {

    private static final PassengerController INSTANCE = new PassengerController();
    private final PassengerService passengerService = PassengerServiceImpl.getInstance();

    private PassengerController() {}

    public static PassengerController getInstance() {
        return INSTANCE;
    }

    public void addPassenger(AddPassengerRequest request) {
        passengerService.addPassenger(request);
    }

    public List<GetPassengerResponse> getAllPassengers() { return passengerService.getAllPassengers();
    }

}