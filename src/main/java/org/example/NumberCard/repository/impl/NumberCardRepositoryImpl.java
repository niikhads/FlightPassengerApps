package org.example.NumberCard.repository.impl;

import org.example.NumberCard.entity.NumberCard;
import org.example.NumberCard.repository.NumberCardRepository;
import org.example.FlightAndPassenger.entity.Flight;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberCardRepositoryImpl implements NumberCardRepository {

    private static final NumberCardRepositoryImpl INSTANCE = new NumberCardRepositoryImpl();

    private NumberCardRepositoryImpl() {
    }

    public static NumberCardRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<NumberCard> getAll() {

        try {
            Connection conn = getConnection();

            String query = "SELECT flight.number, flight.origin, flight.destination FROM flight;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<NumberCard> numberCards = new ArrayList<>();

            while (resultSet.next()) {
                NumberCard numberCard = NumberCard.builder()
                        .number(resultSet.getLong("number"))
                        .origin(resultSet.getString("origin"))
                        .destination(resultSet.getString("destination"))
                        .build();

                numberCards.add(numberCard);
            }

            conn.close();
            return numberCards;

        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public NumberCard getByNumber(Long number) {

        try {
            Connection conn = getConnection();

            String query = "SELECT flight.number, flight.origin, flight.destination FROM flight WHERE flight.number = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, number);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() == false) {
                return null;
            }
            NumberCard numberCard = NumberCard.builder()
                    .number(resultSet.getLong("number"))
                    .origin(resultSet.getString("origin"))
                    .destination(resultSet.getString("destination"))
                    .build();

            conn.close();
            return numberCard;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(NumberCard numberCard ) {

        try {
            Connection conn = getConnection();

            String query = "INSERT INTO flight (origin, destination) VALUES (?, ?,);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, numberCard.getName()); // sorus
            preparedStatement.setString(2, numberCard.getDestination());

            preparedStatement.executeUpdate();

            conn.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(NumberCard numberCard ) {

        try {
            Connection conn = getConnection();

            String query = "UPDATE flight SET flight.name = ?, flight.surname = ? WHERE flight.number = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, numberCard.getName());  // sorus 2 eyni sey
            preparedStatement.setString(2, numberCard.getDestination());
            preparedStatement.setLong(7, numberCard.getNumber());

            preparedStatement.executeUpdate();

            conn.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean delete(Long number) {

        try {
            Connection conn = getConnection();

            String query = "DELETE FROM flight WHERE flight.number = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, number);

            preparedStatement.executeUpdate();

            conn.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "\"jdbc:mysql://localhost:3306/Passenger_system?useSSL=false\";";
            String username = "root";
            String password = "Nihad2004";
            return DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("exception occurred");
        }
    }

}