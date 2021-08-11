package com.activemesa.structural.bridge;

public class Exercise {

  abstract class Shape
  {
    public Renderer renderer;

    public abstract String getName();
  }

  class Triangle extends Shape
  {
    @Override
    public String getName()
    {
      return "Triangle";
    }
  }

  class Square extends Shape
  {
    @Override
    public String getName()
    {
      return "Square";
    }
  }

  class VectorSquare extends Square
  {
    @Override
    public String toString()
    {
      return String.format("Drawing %s as lines", getName());
    }
  }

  class RasterSquare extends Square
  {
    @Override
    public String toString()
    {
      return String.format("Drawing %s as pixels", getName());
    }
  }
}
