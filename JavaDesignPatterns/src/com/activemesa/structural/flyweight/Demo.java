package com.activemesa.structural.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

class User {

  private String fullName;

  public User(String fullName) {
    this.fullName = fullName;
  }
}

class User2 {

  static List<String> strings = new ArrayList<>();
  private int[] names;

  public User2(String fullName){

    Function<String, Integer> getOrAdd = s -> {
      int idx = strings.indexOf(s);

      if (idx != -1) {
        return idx;
      } else {
        strings.add(s);
        return strings.size() - 1;
      }
    };

    names = Stream.of(fullName.split(" "))
        .mapToInt(getOrAdd::apply)
        .toArray();
  }
}

public class Demo {

  public static void main(String[] args) {
    User user = new User("John Smith");
    User user2 = new User("Jane Smith");

    User2 user3 = new User2("Jane Smith");
    User2 user4 = new User2("Jane Smith");
  }
}
