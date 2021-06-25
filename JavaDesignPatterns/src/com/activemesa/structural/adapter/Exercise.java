package com.activemesa.structural.adapter;

class Square
{
    public int side;

    public Square(int side)
    {
        this.side = side;
    }
}

interface Rectangle
{
    int getWidth();
    int getHeight();

    default int getArea()
    {
        return getWidth() * getHeight();
    }
}

class SquareToRectangleAdapter implements Rectangle
{
    public SquareToRectangleAdapter(Square square)
    {
        // todo
    }
}

public class Exercise {
}
