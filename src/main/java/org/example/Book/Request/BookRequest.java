package org.example.Book.Request;

import java.util.Objects;
import org.example.FlightAndPassenger.entity.Flight;
import org.example.FlightAndPassenger.entity.Passenger;

public class BookRequest {

    private Long number;
    private long id;

    @Override
    public String toString() {
        return "BookRequest{" +
                "FlightNumber=" + number +
                ", PassengerId=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookRequest that = (BookRequest) o;
        return id == that.id && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, id);
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}