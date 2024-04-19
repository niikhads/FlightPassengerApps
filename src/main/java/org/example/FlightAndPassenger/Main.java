package org.example.FlightAndPassenger;

import org.example.FlightAndPassenger.controller.FlightController;
import org.example.FlightAndPassenger.controller.PassengerController;
import org.example.FlightAndPassenger.dto.request.AddFlightRequest;
import org.example.FlightAndPassenger.dto.request.AddPassengerRequest;
import org.example.FlightAndPassenger.dto.response.GetFlightResponse;
import org.example.FlightAndPassenger.dto.response.GetPassengerResponse;
import org.example.FlightAndPassenger.util.RequestBuilderUtil;


import java.util.List;
import java.util.Scanner;

public class Main {

    private static final FlightController flightController = FlightController.getInstance();
    private static final PassengerController passengerController = PassengerController.getInstance();

    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }

    private static void menu() {
        System.out.println("""
                --------------------------------------------
                Choose your process:
                1. add Flight
                2. get Flight
                3.add Passenger
                4. get PassengerInformation """);

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                addFlight();

                break;
            case 2:
                getAllFlights();

                break;
            case 3:
                addPassenger();
                break;
            case 4:
                getAllPassengers();
            default:
                defaultSwitchCase();
        }
    }

    private static void addFlight() {
        AddFlightRequest addFlightRequest = RequestBuilderUtil.addFlight();
        flightController.addFlight(addFlightRequest);
    }

    private static void addPassenger() {
        AddPassengerRequest addPassengerRequest = RequestBuilderUtil.addPassenger();
        passengerController.addPassenger(addPassengerRequest);
    }

    private static void getAllFlights() {
        List<GetFlightResponse> flights = flightController.getAllFlights();
        for (GetFlightResponse flight : flights) {
            System.out.println(flight.toString());
        }
    }

    private static void getAllPassengers() {
        List<GetPassengerResponse> passengers = passengerController.getAllPassengers();
        for (GetPassengerResponse passenger : passengers) {
            System.out.println(passenger.toString());
        }
    }

    private static void defaultSwitchCase() {
        System.out.println("Your choice is not OK for us. Please choose again");
        menu();
    }

}