package org.example.FlightAndPassenger.dto.response;

import java.util.Objects;

public class GetPassengerResponse {


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
        GetPassengerResponse that = (GetPassengerResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash( id ,name, surname, age);
    }

    @Override
    public String toString() {
        return  id + ". name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age='" + age + '\'';
    }
}