package com.example.tabby.models;

public class Person {
    private String namePerson;
    private Country country;

    public Person(String namePerson, Country country) {
        this.namePerson = namePerson;
        this.country = country;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
