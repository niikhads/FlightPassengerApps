package org.example.FlightAndPassenger.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Flight {


    private Long number;

    private String origin;
    private String destination;
    private LocalDate departuretime;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(LocalDate departuretime) {
        this.departuretime = departuretime;
    }
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(origin, flight.origin) && Objects.equals(destination, flight.destination) && Objects.equals(departuretime, flight.departuretime) && Objects.equals(number,flight.number);
    }


    @Override
    public int hashCode() {
        return Objects.hash(origin, destination, departuretime, number);
    }

    @Override
    public String toString() {
        return "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departure time='" + departuretime + '\'' +
                 ", flightnumber=" + number;
    }
}

