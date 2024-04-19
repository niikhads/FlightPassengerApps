package org.example.FlightAndPassenger.util;

public final class IdAndNumberGeneratorUtil {

    private IdAndNumberGeneratorUtil() {}

    private static Long PassengerId = 0L;

    private static Long FlightNumber= 0L;


    public static Long getNewPassengerId() {
        return PassengerId++;
    }
    public static Long getNewFlightNumber() {
        return FlightNumber++;
    }

}