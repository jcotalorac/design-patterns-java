package com.activemesa.structural.facade;

class Buffer {

  private char[] characters;
  private int lineWidth;

  public Buffer(int lineHeight, int lineWidth) {
    this.lineWidth = lineWidth;
    characters = new char[lineWidth * lineHeight];
  }
}

public class Demo {
}
