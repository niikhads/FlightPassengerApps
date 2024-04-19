package org.example.Book.Controller;


import org.example.Book.Request.BookRequest;
import org.example.Book.Service.BookService;

public class BookController {
    private  final BookService bookService= new BookService();
    public void AllowBook(BookRequest allowRequest){
        bookService.allowBook(allowRequest);
    }
    public void CancelBook(BookRequest requestCancel){bookService.cancelBook(requestCancel);
    }
}