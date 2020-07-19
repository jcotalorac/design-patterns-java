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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Relationships {
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }
}

class Research {
    public Research(Relationships relationships) {
        relationships.getRelations().stream().filter(relationship -> relationship.getValue0().name.equals("John")
                && relationship.getValue1() == Relationship.PARENT).forEach(JohnChildren -> System.out.println("John children: " + JohnChildren.getValue2()));
    }
}

public class Demo {
}