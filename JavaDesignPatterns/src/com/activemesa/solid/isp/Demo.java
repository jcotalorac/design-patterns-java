package com.activemesa.solid.isp;

class Document {}

interface Machine {
    void print(Document document);
    void fax(Document document);
    void scan(Document document);
}

public class Demo {
}