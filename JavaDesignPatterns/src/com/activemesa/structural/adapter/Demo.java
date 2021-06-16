package com.activemesa.structural.adapter;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line {

    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
}

public class Demo {
}
