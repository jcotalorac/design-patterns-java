import java.util.ArrayList;
import java.util.List;

public class Demo {
}

class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (count++) + ": " + text);
    }
}