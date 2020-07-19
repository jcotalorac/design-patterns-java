package com.activemesa.solid.dip;

import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser { //low-level
    private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public void addParentAndChild(Person parent, Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }

    @Override
    public List<Person> findAllChildrenOf(String name) {
        return relations.stream().filter(relationship -> relationship.getValue0().name.equals(name)
            && relationship.getValue1() == Relationship.PARENT).map(Triplet::getValue2).collect(Collectors.toList());
    }
}

class Research { //high-level
    /*public Research(Relationships relationships) {
        relationships.getRelations().stream().filter(relationship -> relationship.getValue0().name.equals("John")
                && relationship.getValue1() == Relationship.PARENT).forEach(JohnChildren -> System.out.println("John children: " + JohnChildren.getValue2()));
    }*/

    public Research(RelationshipBrowser browser) {
        browser.findAllChildrenOf("John").stream().forEach(children -> System.out.println(children));
    }
}

public class Demo {
    public static void main(String[] args) {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }
}