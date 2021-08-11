package com.activemesa.structural.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GraphicObject {

  protected String name = "Group";
  public String color;
  public List<GraphicObject> children = new ArrayList<>();

  public GraphicObject() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    print(sb, 0);
    return sb.toString();
  }

  private void print(StringBuilder sb, int depth) {
    sb.append(String.join("", Collections.nCopies(depth, "*")))
    .append(depth > 0 ? " " : "")
    .append((color == null || color.isEmpty()) ? "" : " ")
    .append(getName())
    .append(System.lineSeparator());

    for (GraphicObject child :
        children) {
      child.print(sb, depth + 1);
    }
  }
}

class Circle extends GraphicObject {

  public Circle(String color) {
    name = "Circle";
    this.color = color;
  }
}

class Square extends GraphicObject {

  public Square(String color) {
    name = "Square";
    this.color = color;
  }
}

public class Demo {
}
