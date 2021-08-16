package com.activemesa.structural.facade;

import java.util.ArrayList;
import java.util.List;

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

  public char charAt(int x, int y) {
    return buffer.charAt(x + offsetX, y + offsetY);
  }
}

class Console {

  private List<Viewport> viewports = new ArrayList<>();
  private int width, height;

  public Console(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public void addViewport(Viewport viewport) {
    viewports.add(viewport);
  }

  public void render() {
    for (int y = 0; y < height; ++y) {
      for (int x = 0; x < width; ++x) {
        for (Viewport vp : viewports) {
          System.out.print(vp.charAt(x, y));
        }
        System.out.println();
      }
    }
  }
}

public class Demo {
}
