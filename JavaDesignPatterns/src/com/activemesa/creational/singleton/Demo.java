package com.activemesa.creational.singleton;

import com.google.common.collect.Iterables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

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

    EnumBasedSingleton() {
      value = 42;
    }

    private int value;

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }
}

class ChiefExecutiveOfficer {

    private static String name;
    private static int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ChiefExecutiveOfficer.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        ChiefExecutiveOfficer.age = age;
    }

    @Override
    public String toString() {
        return "ChiefExecutiveOfficer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

enum Subsystem {
    PRIMARY,
    AUXILIARY,
    FALLBACK
}

class Printer {

    private static int instanceCount = 0;
    private static HashMap<Subsystem, Printer> instances = new HashMap<>();

    private Printer() {
        instanceCount++;
        System.out.println("A total of " + instanceCount + " instances created so far.");
    }

    public static Printer get(Subsystem ss) {
        if (instances.containsKey(ss)) {
            return instances.get(ss);
        } else {
            Printer instance = new Printer();
            instances.put(ss, instance);
            return instance;
        }
    }
}

class SingletonDatabase {

    private Dictionary<String, Integer> capitals = new Hashtable<>();
    private static int instanceCount = 0;

    public static int getCount() {
        return instanceCount;
    }

    private SingletonDatabase() {
        instanceCount++;
        System.out.println("Initializing database");

        try {
            File file = new File(SingletonDatabase.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            Path fullPath = Paths.get(file.getPath(), "capitals.txt");

            List<String> lines = Files.readAllLines(fullPath);

            Iterables.partition(lines, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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

    static void saveToFileEnum(EnumBasedSingleton singleton, String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream ous = new ObjectOutputStream(fos)) {
            ous.writeObject(singleton);
        }
    }

    static EnumBasedSingleton readFromFileEnum(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (EnumBasedSingleton) ois.readObject();
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

        String fileEnumName = "myfile.bin";

        /*EnumBasedSingleton enumBasedSingleton = EnumBasedSingleton.INSTANCE;
        enumBasedSingleton.setValue(111);
        saveToFileEnum(enumBasedSingleton, fileEnumName);*/



        EnumBasedSingleton enumBasedSingleton2 = readFromFileEnum(fileEnumName);
        //System.out.println(enumBasedSingleton.getValue());
        System.out.println(enumBasedSingleton2.getValue());

        ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
        ceo.setName("Adam Smith");
        ceo.setAge(55);

        ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
        System.out.println(ceo2);

        Printer main = Printer.get(Subsystem.PRIMARY);
        Printer aux = Printer.get(Subsystem.AUXILIARY);
        Printer aux2 = Printer.get(Subsystem.AUXILIARY);
    }
}