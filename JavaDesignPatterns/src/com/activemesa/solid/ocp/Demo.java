package com.activemesa.solid.ocp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products = Stream.of(apple, tree, house).collect(Collectors.toList());

        ProductFilter pf = new ProductFilter();
        pf.filterByColor(products, Color.GREEN).forEach(product -> System.out.println(product));

        BetterProductsFilter betterProductsFilter = new BetterProductsFilter();
        betterProductsFilter.filter(products, new ColorSpecification(Color.GREEN)).forEach(product -> System.out.println(product));

        SizeSpecification large = new SizeSpecification(Size.LARGE);
        ColorSpecification blue = new ColorSpecification(Color.BLUE);
        betterProductsFilter.filter(products, new AndSpecification<>(large, blue)).forEach(product -> System.out.println(product));
    }
}

enum Color {
    RED,
    GREEN,
    BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE, HUGE
}

class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", size=" + size +
                '}';
    }
}

interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> specification);
}

class ColorSpecification implements Specification<Product> {
    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}

class SizeSpecification implements Specification<Product> {
    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}

class AndSpecification<T> implements Specification<T> {
    private Specification<T> first, second;

    public AndSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

class BetterProductsFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> specification) {
        return items.stream().filter(product -> specification.isSatisfied(product));
    }
}

class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(product -> product.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(product -> product.size == size);
    }

    public Stream<Product> filterBySizeAndColor(List<Product> products, Color color, Size size) {
        return products.stream().filter(product -> product.color == color && product.size == size);
    }
}