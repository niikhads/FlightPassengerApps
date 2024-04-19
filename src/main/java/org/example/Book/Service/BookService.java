package org.example.Book.Service;


import org.example.Book.Entity.Book;
import org.example.Book.Mapper.MapperBook;
import org.example.Book.Repository.BookRepository;
import org.example.Book.Repository.Impl.BookMySqlRepositoryImpl;
import org.example.Book.Request.BookRequest;
import org.example.FlightAndPassenger.mapper.PassengerMapper;




public class BookService {
    private final BookRepository bookRepository  = BookMySqlRepositoryImpl.getInstance();
    private final PassengerMapper passengerMapper  = new PassengerMapper();
    public  void cancelBook(BookRequest requestCancel){
        Book book= MapperBook.Cancel(requestCancel);
        bookRepository.cancel(book);
    }
    public  void allowBook(BookRequest requestAllow){
        Book books= MapperBook.Allow(requestAllow);
        bookRepository.allow(books);
    }
}