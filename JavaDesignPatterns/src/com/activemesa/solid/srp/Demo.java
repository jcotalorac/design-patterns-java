package com.activemesa.solid.srp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("I ate a bug");
        System.out.println(j);

        Persistence p = new Persistence();
        String filename = "/tmp/journal.txt";
        p.saveToFile(j, filename, true);
        Runtime.getRuntime().exec("gnome-text-editor " + filename);
    }
}

class Persistence {
   public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
       if (overwrite || new File(filename).exists()) {
           try (PrintStream out = new PrintStream(filename)) {
               out.println(journal.toString());
           }
       }

    }

    public void load(Journal journal, String filename) {
    }

    public void load(URL url, Journal journal) {
    }
}

class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (count++) + ": " + text);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return "Journal{" +
                "entries=" + entries +
                '}';
    }

}