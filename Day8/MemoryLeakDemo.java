package Day8;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeakDemo {

    // List that can lead to a memory leak if not cleared
    private List<String> stringList = new ArrayList<>();

    // Method to simulate adding data to the list
    public void addStrings() {
        for (int i = 0; i < 100000; i++) {
            stringList.add("String " + i);  // Adding strings to the list
        }
        // No clearing of the list here, leading to potential memory leak
    }

    public static void main(String[] args) {
        MemoryLeakDemo demo = new MemoryLeakDemo();
        demo.addStrings();
        
        // At this point, the stringList has 100000 items, which are not cleared.
        // This simulates a memory leak situation.

        System.out.println("Memory leak demo finished.");
    }
}
