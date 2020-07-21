package com.activemesa.creational.builder;

class CodeBuilder {
    public CodeBuilder(String className) {
    }

    public CodeBuilder addField(String name, String type) {
    }
}
public class Coding {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }
}
