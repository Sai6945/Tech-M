package Day8;

class SharedResource {
    private int counter = 0;

    public void increment() {
        counter++; // Potential race condition
    }

    public int getCounter() {
        return counter;
    }
}

class Worker extends Thread {
    private SharedResource resource;

    public Worker(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            resource.increment();
        }
    }
}

public class RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();
        
        Thread t1 = new Worker(resource);
        Thread t2 = new Worker(resource);
        
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter: " + resource.getCounter()); // Should be 2000 but often is not!
    }
}
