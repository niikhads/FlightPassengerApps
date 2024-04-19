package org.example.Book.Repository;

import org.example.Book.Entity.Book;
import org.example.FlightAndPassenger.entity.Passenger;
import org.example.FlightAndPassenger.entity.Flight;



public interface BookRepository {
    void cancel(Book book);
    void allow (Book book);
}