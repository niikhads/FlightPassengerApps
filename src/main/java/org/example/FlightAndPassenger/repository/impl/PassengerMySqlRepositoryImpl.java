package org.example.FlightAndPassenger.repository.impl;
import org.example.FlightAndPassenger.entity.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class  PassengerMySqlRepositoryImpl extends PassengerRepositoryImpl {
    private static final PassengerMySqlRepositoryImpl INSTANCE =new PassengerMySqlRepositoryImpl();
    private PassengerMySqlRepositoryImpl(){
        super();

    }
    public static PassengerMySqlRepositoryImpl getInstance(){
        return INSTANCE;
    }

    public void AddPassenger(Passenger passenger){
        try{
            Connection cn = getConnection();
            String query ="INSERT INTO client (id,name,surname, age) values(?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(query);
            pst.setString(1, passenger.getName());
            pst.setString(2, passenger.getSurname());
            pst.setString(4, String.valueOf(passenger.getAge()));
            pst.executeUpdate();
            cn.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Passenger> getAllPassengers(){
        try {
            Connection cn =getConnection();
            String query = "SELECT id,name,surname,age FROM client";
            Statement st = cn.createStatement();
            ResultSet resultSet=st.executeQuery(query);
            List<Passenger>passengerList= new ArrayList<>();
            while (resultSet.next()){
                long id =resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                Passenger passenger = new Passenger();
                passenger.setId(id);
                passenger.setName(name);
                passenger.setSurname(surname);
                passenger.setAge(age);
                passengerList.add(passenger);


            }
            cn.close();
            return passengerList;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();

        }
    }
    private  Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Passenger_system?useSSL=false";
            String username = "root";
            String password = "Nihad2004";
            return  DriverManager.getConnection(url,username,password);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("error");
        }
    }

}