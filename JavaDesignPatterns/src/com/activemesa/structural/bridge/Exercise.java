package com.activemesa.structural.bridge;

abstract class Shape
{
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

public class Exercise {
}
