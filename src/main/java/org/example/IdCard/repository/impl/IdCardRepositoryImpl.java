package org.example.IdCard.repository.impl;

import org.example.IdCard.model.IdCard;
import org.example.IdCard.repository.IdCardRepository;
import org.example.FlightAndPassenger.entity.Passenger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IdCardRepositoryImpl implements IdCardRepository {

    private static final IdCardRepositoryImpl INSTANCE = new IdCardRepositoryImpl();

    private IdCardRepositoryImpl() {
    }

    public static IdCardRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<IdCard> getAll() {

        try {
            Connection conn = getConnection();

            String query = "SELECT id, name, surname, age FROM client ;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<IdCard> idCards = new ArrayList<>();

            while (resultSet.next()) {
                IdCard idCard = IdCard.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .age(resultSet.getInt("age"))
                        .build();

                idCards.add(idCard);
            }

            conn.close();
            return idCards;

        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public IdCard getById(Long id) {

        try {
            Connection conn = getConnection();

            String query = "SELECT id, client.name, client.surname, client.age  FROM client  WHERE client.id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() == false) {
                return null;
            }
            IdCard idCard = IdCard.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .surname(resultSet.getString("surname"))
                    .age(resultSet.getInt("age"))
                    .build();

            conn.close();
            return idCard;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(IdCard idCard) {

        try {
            Connection conn = getConnection();

            String query = "INSERT INTO client (name, surname, age ) VALUES (?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, idCard.getName());
            preparedStatement.setString(2, idCard.getSurname());
            preparedStatement.setInt(3, idCard.getAge());

            preparedStatement.executeUpdate();

            conn.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(IdCard idCard) {

        try {
            Connection conn = getConnection();

            String query = "UPDATE client  SET client.name = ?, client.surname = ?, client.age = ?  WHERE client.id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, idCard.getName());
            preparedStatement.setString(2, idCard.getSurname());
            preparedStatement.setInt(3, idCard.getAge());
            preparedStatement.setLong(7, idCard.getId());

            preparedStatement.executeUpdate();

            conn.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean delete(Long id) {

        try {
            Connection conn = getConnection();

            String query = "DELETE FROM cleint WHERE client.id = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, id);

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