package com.activemesa.creational.singleton;

class BasicSingleton {
    private static final BasicSingleton instance = new BasicSingleton();

    private int value = 0;
    private BasicSingleton() {
    }

    public static BasicSingleton getInstance() {
        return instance;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class Demo {
    public static void main(String[] args) {
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(123);
        System.out.println(singleton.getValue());
    }
}