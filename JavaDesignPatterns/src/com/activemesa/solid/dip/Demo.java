package com.activemesa.solid.dip;

import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;

enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}

class Relationships {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
}

public class Demo {
}