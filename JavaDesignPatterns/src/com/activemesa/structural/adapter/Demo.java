package com.activemesa.structural.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

class VectorObject extends ArrayList<Line> {}

class VectorRectangle extends VectorObject {

    public VectorRectangle(int x, int y, int width, int height) {
        add(new Line(new Point(x, y), new Point(x + width, y)));
        add(new Line(new Point(x + width, y), new Point(x + width, y + height)));
        add(new Line(new Point(x + width, y + width), new Point(x, y + height)));
        add(new Line(new Point(x, y + height), new Point(x, y)));
    }
}

class LineToPointAdapter extends ArrayList<Point> {

    public LineToPointAdapter(Line line) {
    }
}

public class Demo {

    private final static List<VectorObject> vectorObjects = new ArrayList<>(Arrays.asList(new VectorRectangle(1,1,10,10),
            new VectorRectangle(3, 3, 6, 6)));

    public static void drawPoint(Point P) {
        System.out.println(".");
    }
}
