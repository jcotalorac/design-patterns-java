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

class FormattedText {

  private String plainText;
  private boolean[] capitalize;

  public FormattedText(String plainText) {
    this.plainText = plainText;
    this.capitalize = new boolean[plainText.length()];
  }

  public void capitalize(int start, int end) {
    for (int i = start; i <= end; i++) {
      capitalize[i] = true;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < plainText.length(); ++i) {
      sb.append(capitalize[i] ? Character.toUpperCase(plainText.charAt(i)) : plainText.charAt(i));
    }
    return sb.toString();
  }
}

class BetterFormattedText {

  private String plainText;
  private List<TextRange> formatting = new ArrayList<>();

  public BetterFormattedText(String plainText) {
    this.plainText = plainText;
  }

  public class TextRange {
    public int start, end;
    public boolean capitalize, bold, italic;

    public TextRange(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public boolean covers(int position) {
      return position >= start && position <= end;
    }
  }
}

public class Demo {

  public static void main(String[] args) {
    User user = new User("John Smith");
    User user2 = new User("Jane Smith");

    User2 user3 = new User2("Jane Smith");
    User2 user4 = new User2("Jane Smith");

    FormattedText ft = new FormattedText("This is a brave new world");
    ft.capitalize(10, 15);
    System.out.println(ft);
  }
}