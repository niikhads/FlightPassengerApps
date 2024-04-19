package org.example.FlightAndPassenger.mapper;

import org.example.FlightAndPassenger.dto.request.AddFlightRequest;
import org.example.FlightAndPassenger.dto.response.GetFlightResponse;
import org.example.FlightAndPassenger.entity.Flight;
import org.example.FlightAndPassenger.util.TimeUtil;
import java.util.ArrayList;
import java.util.List;

public class FlightMapper {
    private static final FlightMapper INSTANCE = new FlightMapper();

    private FlightMapper() {}

    public static FlightMapper getInstance() {
        return INSTANCE;
    }

    public Flight toFlight(AddFlightRequest addFlightRequest ){
        Flight flight = new Flight();
        flight.setOrigin(addFlightRequest.getOrigin());
        flight.setDestination(addFlightRequest.getDestination());
        flight.setDeparturetime(
                TimeUtil.toLocalDate(
                        addFlightRequest.getDeparturetime()
                )
        );

        return flight;
    }

    public List<GetFlightResponse> toGetFlightResponseList(List<Flight> flightList) {
        List<GetFlightResponse> getFlightResponseList= new ArrayList<>();

        for (Flight flight: flightList) {
            GetFlightResponse getFlightResponse = new GetFlightResponse();
            getFlightResponse.setNumber(flight.getNumber());
            getFlightResponse.setOrigin(flight.getOrigin());
            getFlightResponse.setDestination(flight.getDestination());
            getFlightResponse.setDeparturetime(
                    TimeUtil.toString(
                            flight.getDeparturetime()
                    )
            );
            getFlightResponseList.add(getFlightResponse);
        }

        return getFlightResponseList;
    }

}