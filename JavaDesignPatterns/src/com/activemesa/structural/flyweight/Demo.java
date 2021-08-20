package com.activemesa.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

class User {

  private String fullName;

  public User(String fullName) {
    this.fullName = fullName;
  }
}

class User2 {

  static List<String> strings = new ArrayList<>();
  private int[] names;
}

public class Demo {

  public static void main(String[] args) {
    User user = new User("John Smith");
    User user2 = new User("Jane Smith");
  }
}
