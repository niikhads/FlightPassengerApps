package org.example.FlightAndPassenger.service.impl;

import org.example.FlightAndPassenger.mapper.PassengerMapper;
import org.example.FlightAndPassenger.service.PassengerService;
import org.example.FlightAndPassenger.repository.PassengerRepository;
import org.example.FlightAndPassenger.repository.impl.PassengerRepositoryImpl;
import org.example.FlightAndPassenger.util.IdAndNumberGeneratorUtil;
import org.example.FlightAndPassenger.dto.request.AddPassengerRequest;
import org.example.FlightAndPassenger.dto.response.GetPassengerResponse;
import org.example.FlightAndPassenger.entity.Passenger;

import java.util.List;

public class PassengerServiceImpl implements PassengerService {

    private static final PassengerServiceImpl INSTANCE = new PassengerServiceImpl();
    private final PassengerRepository passengerRepository = PassengerRepositoryImpl.getInstance();
    private final PassengerMapper passengerMapper = PassengerMapper.getInstance();

    private PassengerServiceImpl() {}

    public static PassengerServiceImpl getInstance() {
        return INSTANCE;
    }

    public void addPassenger(AddPassengerRequest request) {
        Passenger passenger = passengerMapper.toPassenger(request);
        passenger.setId(IdAndNumberGeneratorUtil.getNewPassengerId());

        PassengerRepositoryImpl.getInstance().addPassenger(passenger);
    }

    public List<GetPassengerResponse> getAllPassengers() {
        List<Passenger> passengers = passengerRepository.getAllPassengers();
        return passengerMapper.toGetPassengerResponseList(passengers);
    }
}