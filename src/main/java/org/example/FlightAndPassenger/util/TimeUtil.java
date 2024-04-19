package org.example.FlightAndPassenger.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class TimeUtil {

    private TimeUtil() {}

    public static LocalDate toLocalDate(String departuretime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Day/Month/Year");
        return LocalDate.parse(departuretime, formatter);
    }

    public static String toString(LocalDate departuretime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Day/Month/year");
        return departuretime.format(formatter);
    }
}