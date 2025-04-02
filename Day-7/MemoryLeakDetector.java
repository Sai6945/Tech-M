import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;


public class MemoryLeakDetector {

    // Static List simulating a memory leak
    private static final List<byte[]> memoryLeakList = new ArrayList<>();

    public static void main(String[] args) {

        // Start a memory monitoring thread
        Thread memoryMonitor = new Thread(MemoryLeakDetector::monitorMemoryUsage);
        memoryMonitor.setDaemon(true);
        memoryMonitor.start();

        // Try to simulate a memory leak
        try {
            simulateMemoryLeak();
        } catch (OutOfMemoryError e) {
            System.out.println("⚠ Out of Memory! Attempting to fix...");
            fixMemoryLeak();
        }
    }

    // Simulate a memory leak by continuously adding large byte arrays to a list
    private static void simulateMemoryLeak() {
        System.out.println("🔍 Simulating memory leak...");
        for (int i = 0; i < 1000; i++) {
            byte[] data = new byte[1024 * 1024]; // Allocate 1MB
            memoryLeakList.add(data); // Hold reference -> Memory Leak

            // Show progress
            if (i % 50 == 0) {
                System.out.println("📝 Allocated: " + (i + 1) + "MB");
            }

            try {
                Thread.sleep(100); // Slow down the process
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Monitor JVM Heap Memory Usage
    private static void monitorMemoryUsage() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        while (true) {
            MemoryUsage heapUsage = memoryMXBean.getHeapMemoryUsage();
            long usedMemory = heapUsage.getUsed();
            long maxMemory = heapUsage.getMax();

            System.out.println("📊 Heap Memory Used: " 
                               + (usedMemory / 1024 / 1024) + "MB / " 
                               + (maxMemory / 1024 / 1024) + "MB");

            try {
                Thread.sleep(2000); // Monitor every 2 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Fix the Memory Leak
    private static void fixMemoryLeak() {
        memoryLeakList.clear(); // Remove all references
        System.gc(); // Request garbage collection
        System.out.println("✅ Memory Leak Fixed: Cleared memoryLeakList and triggered GC.");
    }
}
