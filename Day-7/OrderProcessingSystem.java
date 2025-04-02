package daay7;

import java.util.LinkedList;
import java.util.Queue;

class OrderQueue {
    private final Queue<String> orders = new LinkedList<>();
    
    // Synchronize adding an order
    public synchronized void placeOrder(String order) {
        orders.add(order);
        System.out.println(Thread.currentThread().getName() + " placed order: " + order);
        notify(); // Notify consumer threads
    }

    // Synchronize processing an order
    public synchronized String processOrder() throws InterruptedException {
        while (orders.isEmpty()) {
            wait(); // Wait if no orders
        }
        return orders.poll(); // Remove and return processed order
    }
}

// Producer Thread (Simulates customers placing orders)
class OrderProducer implements Runnable {
    private final OrderQueue orderQueue;
    
    public OrderProducer(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            String order = "Order-" + i;
            orderQueue.placeOrder(order);
            try {
                Thread.sleep(500); // Simulating order placement delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Consumer Thread (Simulates staff processing orders)
class OrderConsumer implements Runnable {
    private final OrderQueue orderQueue;

    public OrderConsumer(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String order = orderQueue.processOrder();
                System.out.println(Thread.currentThread().getName() + " processed: " + order);
                Thread.sleep(1000); // Simulating processing time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Main Class
public class OrderProcessingSystem {
    public static void main(String[] args) {
        OrderQueue orderQueue = new OrderQueue();

        // Create and start producer threads (Customers placing orders)
        Thread producer1 = new Thread(new OrderProducer(orderQueue), "Customer-1");
        Thread producer2 = new Thread(new OrderProducer(orderQueue), "Customer-2");

        // Create and start consumer threads (Staff processing orders)
        Thread consumer1 = new Thread(new OrderConsumer(orderQueue), "Staff-1");
        Thread consumer2 = new Thread(new OrderConsumer(orderQueue), "Staff-2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
