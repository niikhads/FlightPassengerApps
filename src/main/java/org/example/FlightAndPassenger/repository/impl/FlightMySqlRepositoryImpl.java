package org.example.FlightAndPassenger.repository.impl;

import org.example.FlightAndPassenger.entity.Flight;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightMySqlRepositoryImpl extends FlightRepositoryImpl {
    private static final FlightMySqlRepositoryImpl INSTANCE =new FlightMySqlRepositoryImpl();
    private FlightMySqlRepositoryImpl(){
        super();

    }
    public static FlightMySqlRepositoryImpl getInstance(){
        return INSTANCE;
    }
    @Override
    public void AddFlight(Flight flight ){
        try{
            Connection cn = getConnection();
            String query ="INSERT INTO flight (id, origin, destination) values(?,?,?)";
            PreparedStatement pst=cn.prepareStatement(query);
            pst.setString(1, flight.getOrigin());
            pst.setString(2, flight.getDestination());
            pst.executeUpdate();
            cn.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Flight> getAllFlights(){
        try {
            Connection cn =getConnection();
            String query = "SELECT flightnumber,origin,destination FROM  flight";
            Statement st = cn.createStatement();
            ResultSet resultSet=st.executeQuery(query);
            List<Flight>flightList= new ArrayList<>();
            while (resultSet.next()){
                long number =resultSet.getInt("flight number");
                String origin = resultSet.getString("origin");
                String destination = resultSet.getString("destination");
                Flight flight= new Flight();
                flight.setNumber(number);
                flight.setOrigin(origin);
                flight.setDestination(destination);
                flightList.add(flight);


            }
            cn.close();
            return flightList;
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