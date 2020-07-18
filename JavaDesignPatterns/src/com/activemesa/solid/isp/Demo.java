package com.activemesa.solid.isp;

class Document {}

interface Machine {
    void print(Document document);
    void fax(Document document) throws Exception;
    void scan(Document document) throws Exception;
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

class OldFashionedPrinter implements Machine {

    @Override
    public void print(Document document) {

    }

    @Override
    public void fax(Document document) throws Exception {
        throw new Exception();
    }

    @Override
    public void scan(Document document) throws Exception {
        throw new Exception();
    }
}

interface Printer {
    void print(Document document);
}

interface Scanner {
    void scan(Document document);
}

class JustAPrinter implements Printer {
    @Override
    public void print(Document document) {

    }
}

class Photocopier implements Printer, Scanner {
    @Override
    public void print(Document document) {

    }

    @Override
    public void scan(Document document) {

    }
}

interface MultiFunctionDevice extends Printer, Scanner {}

class MultiFunctionMachine implements MultiFunctionDevice {

    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document document) {
        printer.print(document);
    }

    @Override
    public void scan(Document document) {
        scanner.scan(document);
    }
}

public class Demo {
}