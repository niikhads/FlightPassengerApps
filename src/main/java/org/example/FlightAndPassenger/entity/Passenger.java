package org.example.FlightAndPassenger.entity;


import java.util.Objects;

public class Passenger {



    private Long id;

    private String name;
    private String surname;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id) &&Objects.equals(name, passenger.name) && Objects.equals(surname, passenger.surname) && Objects.equals(age, passenger.age);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id ,name, surname, age);
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age;
    }

}