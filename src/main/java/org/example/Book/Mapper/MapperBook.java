package org.example.Book.Mapper;

import org.example.Book.Request.BookRequest;
import org.example.Book.Entity.Book;


public class MapperBook {
    public static Book Cancel(BookRequest requestCancel) {
        Book book= new Book();
        book.setId(requestCancel.getId());
        book.setNumber(requestCancel.getNumber());

        return book;
    }
    public static Book Allow(BookRequest requestAllow) {
        Book books= new Book();
        books.setId(requestAllow.getId());
        books.setNumber(requestAllow.getNumber());

        return books;
    }
}