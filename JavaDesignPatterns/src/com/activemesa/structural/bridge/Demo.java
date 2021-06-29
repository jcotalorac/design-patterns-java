package com.activemesa.structural.bridge;

interface Renderer {
    void renderCircle(float radius);
}

class VectorRenderer implements Renderer {

    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radius "
        + radius);
    }
}

class RasterRenderer implements Renderer {

    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels for a circle "
                + "of radius " + radius);
    }
}

public class Demo {
}
