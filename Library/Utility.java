package library;  // ✅ Same package

import java.util.concurrent.atomic.AtomicInteger;

public class Utility {
    private static final AtomicInteger counter = new AtomicInteger(1000);

    public static int generateId() {
        return counter.getAndIncrement();
    }
}
