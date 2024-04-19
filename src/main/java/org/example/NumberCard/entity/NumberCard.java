package org.example.NumberCard.entity;

import java.util.Objects;

public class NumberCard {

    private Long number;
    private String origin;
    private String destination;

    public NumberCard(Long number,
                      String origin,
                      String destination) {
        this.number = number;
        this.origin = origin;
        this.destination = destination;
    }

    public static NumberCardBuilder builder() {
        return new NumberCardBuilder();
    }

    public static class NumberCardBuilder {
        private Long number;
        private String origin;
        private String destination;

        public NumberCardBuilder number(Long number) {
            this.number = number;
            return this;
        }

        public NumberCardBuilder origin(String origin) {
            this.origin = origin;
            return this;
        }

        public NumberCardBuilder destination(String destination) {
            this.destination = destination;
            return this;
        }


        public NumberCard build() {
            NumberCard numberCard =
                    new NumberCard(
                            this.number,
                            this.origin,
                            this.destination
                    );
            return numberCard;
        }
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return origin;
    }

    public void setName(String name) {
        this.origin = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberCard numberCard  = (NumberCard) o;
        return number == numberCard.number &&  Objects.equals(origin, numberCard.origin) && Objects.equals(destination, numberCard.destination) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, origin, destination);
    }

    @Override
    public String toString() {
        return "FlightCard{" +
                "FlightNumber=" + number +
                ", name='" + origin + '\'' +
                ", surname='" + destination + '\'' +
                '}';
    }
}