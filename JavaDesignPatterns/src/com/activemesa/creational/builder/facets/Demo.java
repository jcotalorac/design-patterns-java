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

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    public Person build() {
        return person;
    }
}

class PersonAddressBuilder extends PersonBuilder {

    public PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder at(String address) {
        this.person.streetAddress = address;
        return this;
    }

    public PersonAddressBuilder withPostCode(String postCode) {
        this.person.postcode = postCode;
        return this;
    }

    public PersonAddressBuilder in(String city) {
        this.person.city = city;
        return this;
    }
}

class PersonJobBuilder extends PersonBuilder {

    public PersonJobBuilder(Person person) {
        this.person = person;
    }

    public PersonJobBuilder company(String company) {
        this.person.companyName = company;
        return this;
    }

    public PersonJobBuilder asA(String position) {
        this.person.position = position;
        return this;
    }

    public PersonJobBuilder earning(int annualIncome) {
        this.person.annualIncome = annualIncome;
        return this;
    }
}

public class Demo {
}