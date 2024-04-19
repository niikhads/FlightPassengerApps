package org.example.FlightAndPassenger.mapper;

import org.example.FlightAndPassenger.dto.request.AddPassengerRequest;
import org.example.FlightAndPassenger.dto.response.GetPassengerResponse;
import org.example.FlightAndPassenger.entity.Passenger;


import java.util.ArrayList;
import java.util.List;

public class PassengerMapper {

    private static final PassengerMapper INSTANCE = new PassengerMapper();

    public PassengerMapper() {}

    public static PassengerMapper getInstance() {
        return INSTANCE;
    }

    public Passenger toPassenger(AddPassengerRequest addPassengerRequest) {
        Passenger passenger = new Passenger();
        passenger.setName(addPassengerRequest.getName());
        passenger.setSurname(addPassengerRequest.getSurname());
        passenger.setAge(addPassengerRequest.getAge());

        return passenger;
    }

    public List<GetPassengerResponse> toGetPassengerResponseList(List<Passenger> passengerList) {
        List<GetPassengerResponse> getPassengerResponseList = new ArrayList<>();

        for (Passenger passenger : passengerList) {
            GetPassengerResponse getPassengerResponse = new GetPassengerResponse();
            getPassengerResponse.setId(passenger.getId());
            getPassengerResponse.setName(passenger.getName());
            getPassengerResponse.setSurname(passenger.getSurname());
            getPassengerResponse.setAge(passenger.getAge());

           getPassengerResponseList.add(getPassengerResponse);
        }

        return getPassengerResponseList;
    }

}