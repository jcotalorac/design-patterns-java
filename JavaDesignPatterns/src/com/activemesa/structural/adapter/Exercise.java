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
    private Square sq;
    public SquareToRectangleAdapter(Square square)
    {
        sq = square;
    }

    @Override
    public int getWidth() {
        return sq.side;
    }

    @Override
    public int getHeight() {
        return sq.side;
    }
}

public class Exercise {

    public static void main(String[] args) {
        SquareToRectangleAdapter squareToRectangleAdapter = new SquareToRectangleAdapter(new Square(3));

        System.out.println(squareToRectangleAdapter.getArea());
    }
}
