package com.activemesa.creational.singleton;

class BasicSingleton {
    private static final BasicSingleton instance = new BasicSingleton();

    private BasicSingleton() {
    }

    public static BasicSingleton getInstance() {
        return instance;
    }
}

public class Demo {
    public static void main(String[] args) {

    }
}