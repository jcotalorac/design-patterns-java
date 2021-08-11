package com.activemesa.structural.bridge.exercise;

interface Renderer {

  public String whatToRenderAs();
}

class VectorRenderer implements Renderer {

  @Override
  public String whatToRenderAs() {
    return "lines";
  }
}

class RasterRenderer implements Renderer {

  @Override
  public String whatToRenderAs() {
    return "pixels";
  }
}

abstract class Shape
{
  public Renderer renderer;

  Shape(Renderer renderer) {
    this.renderer = renderer;
  }

  @Override
  public String toString()
  {
    return String.format("Drawing %s as %s", this.getName(), this.renderer.whatToRenderAs());
  }

  public abstract String getName();
}

class Triangle extends Shape
{

  Triangle(Renderer renderer) {
    super(renderer);
  }

  @Override
  public String getName()
  {
    return "Triangle";
  }
}

class Square extends Shape
{

  Square(Renderer renderer) {
    super(renderer);
  }
  @Override
  public String getName()
  {
    return "Square";
  }
}

class VectorSquare
{

  private final Shape shape = new Square(new VectorRenderer());

  @Override
  public String toString()
  {
    return shape.toString();
  }
}

class RasterSquare
{
  private final Shape shape = new Square(new RasterRenderer());

  @Override
  public String toString()
  {
    return shape.toString();
  }
}

public class Exercise {



  public static void main(String[] args) {
    System.out.println(new VectorSquare());
    System.out.println(new RasterSquare());
  }
}
