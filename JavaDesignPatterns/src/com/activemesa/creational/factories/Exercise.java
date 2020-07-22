package com.activemesa.creational.factories;


class Person
{
    public static int count = 0;

    public int id;
    public String name;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class PersonFactory
{
    public Person createPerson(String name)
    {
        return new Person(Person.count++, name);
    }
}

public class Exercise {
    public static void main(String[] args) {
        PersonFactory personFactory = new PersonFactory();
        Person person0 = personFactory.createPerson("Person0");
        Person person1 = personFactory.createPerson("Person1");

        System.out.println(person0);
        System.out.println(person1);
    }
}