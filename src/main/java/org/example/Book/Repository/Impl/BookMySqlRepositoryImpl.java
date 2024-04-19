package org.example.Book.Repository.Impl;

import org.example.Book.Entity.Book;
import org.example.Book.Repository.BookRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookMySqlRepositoryImpl implements BookRepository {

    private static final BookMySqlRepositoryImpl INSTANCE = new BookMySqlRepositoryImpl();

    private BookMySqlRepositoryImpl() {

    }

    public static BookMySqlRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void cancel(Book book) {
        try {
            Connection conn = getConnection();

            String query = "delete from books where FligthNumber=? and passengerId =?;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1,book.getNumber());
            preparedStatement.setObject(2,book.getId());
            preparedStatement.executeUpdate();

            conn.close();
            return;

        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }

    @Override
    public void allow(Book book) {

        try {
            Connection conn = getConnection();

            String query = "insert into Books(passengerId,FligthNumber) values(?,?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1,book.getNumber());
            preparedStatement.setLong(2,book.getId());
            preparedStatement.executeUpdate();

            conn.close();
            return;

        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Passenger_system?useSSL=false";;
            String username = "root";
            String password = "Nihad2004";
            return DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("error");

        }
    }

}