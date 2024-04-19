package org.example.FlightAndPassenger.util;

import org.example.FlightAndPassenger.dto.request.AddFlightRequest;
import org.example.FlightAndPassenger.dto.request.AddPassengerRequest;

import java.util.Scanner;

public final class RequestBuilderUtil {
    private RequestBuilderUtil() {
    }

    public static AddFlightRequest addFlight() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter flight number:");
        Long number = sc.nextLong();

        sc = new Scanner(System.in);

        System.out.println("please enter flight origin:");
        String origin = sc.nextLine();

        System.out.println("please enter flight destination:");
        String destination = sc.nextLine();

        System.out.println("please enter flight departure time (date format is -> day/monthNumber/year):");
        String departuretime = sc.nextLine();

        AddFlightRequest addFlightRequest = new AddFlightRequest();
        addFlightRequest.setNumber(number);
        addFlightRequest.setOrigin(origin);
        addFlightRequest.setDestination(destination);
        addFlightRequest.setDeparturetime(departuretime);

        return addFlightRequest;
    }


    public static AddPassengerRequest addPassenger() {
        Scanner sc = new Scanner(System.in);

        System.out.println("please enter passenger name:");
        String name = sc.nextLine();

        System.out.println("please enter passenger surname:");
        String surname = sc.nextLine();

        System.out.println("please enter passenger age");
        int age = sc.nextInt();

        AddPassengerRequest addPassengerRequest = new AddPassengerRequest();
        addPassengerRequest.setName(name);
        addPassengerRequest.setSurname(surname);
        addPassengerRequest.setAge(age);

        return addPassengerRequest;
    }

}