package com.activemesa.creational.prototype;

class Point
{
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this(p.x, p.y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line
{
    public Point start, end;

    public Line(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy()
    {
        return new Line(new Point(this.start),
                new Point(this.end));
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class Exercise {
    public static void main(String[] args) {
        Line line1 = new Line(new Point(1,2),
                new Point(3, 4));
        Line line2 = line1.deepCopy();
        line2.start.x = 5;
        line2.start.y = 6;
        line2.end.x = 7;
        line2.end.y = 8;

        System.out.println(line1);
        System.out.println(line2);
    }
}