package org.example.Book.Util;


import org.example.Book.Request.BookRequest;

import java.util.Scanner;

public class BookUtil {
    private  void BookUtil(){

    }
    public static BookRequest  requestCancel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter cancel passengerId:");
        Long passengerId = sc.nextLong();
        System.out.println("Please enter cancel FligthNumber:");
        Long FligthNumber = sc.nextLong();
        BookRequest requestBook = new BookRequest();
        requestBook.setId(passengerId);
        requestBook.setNumber(FligthNumber);
        return requestBook;
    }

    public static BookRequest requestAllow(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter allow passengerId:");
        Long passengerId = sc.nextLong();
        System.out.println("Please enter allow FligthNumber:");
        Long FligthNumber = sc.nextLong();
        BookRequest requestBook = new BookRequest();
     //   requestBook.setId(passengerId);
        requestBook.setNumber(FligthNumber);
        return requestBook;
    }

}