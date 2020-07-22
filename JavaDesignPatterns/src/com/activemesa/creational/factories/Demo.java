package com.activemesa.creational.factories;

import javafx.util.Pair;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Point {
    private double x, y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    static class PointFactory {

        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }

        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho * Math.cos(theta),
                    rho * Math.sin(theta));
        }
    }
}

interface HotDrink {
    void consume();
}

class Tea implements HotDrink {
    @Override
    public void consume() {
        System.out.println("This tea is delicious");
    }
}

class Coffee implements HotDrink {
    @Override
    public void consume() {
        System.out.println("This coffee is delicious");
    }
}

interface HotDrinkFactory {
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Put in tea bag, boil water, pour " +
                amount + "ml, add lemon, enjoy!");
        return new Tea();
    }
}

class CoffeFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Grind some beans, boil water, pour" +
                amount + "ml, add cream and sugar");
        return new Coffee();
    }
}

class HotDrinksMachine {
    private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

    public HotDrinksMachine() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<Class<? extends HotDrinkFactory>> types = new Reflections("")
                .getSubTypesOf(HotDrinkFactory.class);
        for (Class<? extends HotDrinkFactory> type:
             types) {
            namedFactories.add(new Pair<>(type.getSimpleName()
                    .replace("Factory", ""),
                    type.getDeclaredConstructor().newInstance()));
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        Point point = Point.PointFactory.newCartesianPoint(2, 3);
    }
}