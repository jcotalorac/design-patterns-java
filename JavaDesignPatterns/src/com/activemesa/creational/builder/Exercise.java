package com.activemesa.creational.builder;

class CodeBuilder {
    private StringBuilder output = new StringBuilder();

    public CodeBuilder(String className) {
        output.append("public class ").append(className)
            .append("\n{\n");
    }

    public CodeBuilder addField(String name, String type) {
        output.append("  ").append("public ")
                .append(type).append(" ").append(name)
                .append(";\n");
        return this;
    }

    @Override
    public String toString() {
        return output.append("}").toString();
    }
}

public class Exercise {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }
}
