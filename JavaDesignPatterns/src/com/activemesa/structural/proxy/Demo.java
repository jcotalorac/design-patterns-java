package com.activemesa.structural.proxy;

interface Drivable {

  void drive();
}

class Car implements Drivable {

  protected Driver driver;

  public Car(Driver driver) {
    this.driver = driver;
  }

  @Override
  public void drive() {
    System.out.println("Car being driven");
  }
}

class Driver {

  public int age;

  public Driver(int age) {
    this.age = age;
  }
}

public class Demo {
}
