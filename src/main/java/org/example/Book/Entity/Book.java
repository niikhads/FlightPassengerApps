package org.example.Book.Entity;

import java.util.Objects;

public class Book {
    private long BookId;
    private long number;
    private long id;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + BookId +
                ", FlightNumber=" + number +
                ", passengerId=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return BookId == book.BookId && number == book.number && id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(BookId, number, id);
    }

    public long getBookId() {
        return BookId;
    }

    public void setBookId(long bookId) {
        this.BookId = bookId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}