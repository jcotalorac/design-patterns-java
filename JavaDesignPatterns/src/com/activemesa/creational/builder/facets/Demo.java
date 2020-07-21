package com.activemesa.creational.builder.facets;

class Person {
    public String streetAddress, postcode, city;

    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

class PersonBuilder {
    protected Person person = new Person();

    public Person build() {
        return person;
    }
}

public class Demo {
}