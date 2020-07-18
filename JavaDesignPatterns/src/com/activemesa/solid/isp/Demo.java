package com.activemesa.solid.isp;

class Document {}

interface Machine {
    void print(Document document);
    void fax(Document document);
    void scan(Document document);
}

class MultifunctionPrinter implements Machine {

    @Override
    public void print(Document document) {

    }

    @Override
    public void fax(Document document) {

    }

    @Override
    public void scan(Document document) {

    }
}

public class Demo {
}