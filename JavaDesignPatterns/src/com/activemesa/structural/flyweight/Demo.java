package com.activemesa.structural.flyweight;

class User {

  private String fullName;

  public User(String fullName) {
    this.fullName = fullName;
  }
}

public class Demo {

  public static void main(String[] args) {
    User user = new User("John Smith");
    User user2 = new User("Jane Smith");
  }
}
