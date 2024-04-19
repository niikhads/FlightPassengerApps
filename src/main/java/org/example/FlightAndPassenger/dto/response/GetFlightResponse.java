package org.example.FlightAndPassenger.dto.response;

import java.util.Objects;

public class GetFlightResponse {

    private Long number;
    private String origin;
    private String destination;
    private String departuretime;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

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

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetFlightResponse that = (GetFlightResponse) o;
        return Objects.equals(number, that.number) && Objects.equals(origin, that.origin) && Objects.equals(destination, that.destination) && Objects.equals(departuretime, that.departuretime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, origin, destination, departuretime);
    }

    @Override
    public String toString() {
        return number + ". origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departuretime='" + departuretime + '\'';
    }
}