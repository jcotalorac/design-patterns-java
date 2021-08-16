package com.activemesa.structural.facade;

class Buffer {

  private char[] characters;
  private int lineWidth;

  public Buffer(int lineHeight, int lineWidth) {
    this.lineWidth = lineWidth;
    characters = new char[lineWidth * lineHeight];
  }

  public char charAt(int x, int y) {
    return characters[y * lineWidth + x];
  }
}

class Viewport {

  private final Buffer buffer;
  private final int width;
  private final int height;
  private final int offsetX;
  private final int offsetY;

  public Viewport(Buffer buffer, int width, int height, int offsetX, int offsetY){
    this.buffer = buffer;
    this.width = width;
    this.height = height;
    this.offsetX = offsetX;
    this.offsetY = offsetY;
  }
}

public class Demo {
}
