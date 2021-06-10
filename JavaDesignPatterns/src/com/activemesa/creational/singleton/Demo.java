package com.activemesa.creational.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class BasicSingleton implements Serializable {
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

    protected Object readResolve() {
        return instance;
    }
}

class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() throws IOException {
        System.out.println("Singleton is initializing");
        File.createTempFile("", "");
    }

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (IOException ioe) {
            System.err.println("Failed to create singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}

class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("Initializing a lazy singleton");
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static LazySingleton getInstanceDoubleCheck() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

class InnerStaticSingleton {

    private InnerStaticSingleton(){
    }

    private static class Impl {

        private static final InnerStaticSingleton instance = new InnerStaticSingleton();
    }

    public static InnerStaticSingleton getInstance() {
        return Impl.instance;
    }
}

enum EnumBasedSingleton {
    INSTANCE;
}

public class Demo {

    static void saveToFile(BasicSingleton singleton, String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream ous = new ObjectOutputStream(fos)) {
            ous.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (BasicSingleton) ois.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(123);

        // 1. Reflection problem

        String fileName = "singleton.bin";
        saveToFile(singleton, fileName);

        singleton.setValue(456);

        BasicSingleton singleton2 = readFromFile(fileName);

        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());
        System.out.println(singleton == singleton2);
    }
}