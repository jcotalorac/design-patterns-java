package com.activemesa.creational.singleton;

import java.util.function.Supplier;

class SingletonTester {

    public static boolean isSingleton(Supplier<Object> func) {

        Object obj1 = func.get();
        Object obj2 = func.get();

        return obj1 == obj2 && obj1.equals(obj2);
    }
}

public class Exercise {

    public static void main(String[] args) {
        System.out.println(SingletonTester.isSingleton(() -> Integer.MAX_VALUE));

        System.out.println(SingletonTester.isSingleton(() -> Runtime.getRuntime()));
    }

}
