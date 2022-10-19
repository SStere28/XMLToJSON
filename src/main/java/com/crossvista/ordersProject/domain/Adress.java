package com.crossvista.ordersProject.domain;

import java.util.Objects;

public class Adress {

    private String type;
    private String name;
    private String street;
    private String city;
    private String state;
    private long zip;
    private String country;

    public Adress() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adress)) return false;
        Adress adress = (Adress) o;
        return getZip() == adress.getZip() && Objects.equals(getType(), adress.getType()) && Objects.equals(getName(), adress.getName()) && Objects.equals(getStreet(), adress.getStreet()) && Objects.equals(getCity(), adress.getCity()) && Objects.equals(getState(), adress.getState()) && Objects.equals(getCountry(), adress.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getName(), getStreet(), getCity(), getState(), getZip(), getCountry());
    }

    @Override
    public String toString() {
        return "Adress{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", country='" + country + '\'' +
                '}';
    }
}
