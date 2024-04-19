package org.example.IdCard.model;

import java.util.Objects;

public class IdCard {

    private Long id;
    private String name;
    private String surname;
    private Integer age;

    public IdCard(Long id,
                  String name,
                  String surname,
                  Integer age
                  ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public static IdCardBuilder builder() {
        return new IdCardBuilder();
    }

    public static class IdCardBuilder {
        private Long id;
        private String name;
        private String surname;
        private Integer age;


        public IdCardBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public IdCardBuilder name(String name) {
            this.name = name;
            return this;
        }

        public IdCardBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public IdCardBuilder age(Integer age) {
            this.age = age;
            return this;
        }


        public IdCard build() {
            IdCard idCard =
                    new IdCard(
                            this.id,
                            this.name,
                            this.surname,
                            this.age

                    );
            return idCard;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        IdCard idCard = (IdCard) o;
        return id == idCard.id && age == idCard.age && Objects.equals(name, idCard.name) && Objects.equals(surname, idCard.surname) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age);
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}