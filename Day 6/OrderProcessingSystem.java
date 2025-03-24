package Day6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

// Order Class
class Order {
    private final String orderID;
    private final double amount;
    private final LocalDateTime orderDate;
    private final String status; // PENDING, SHIPPED, DELIVERED

    public Order(String orderID, double amount, LocalDateTime orderDate, String status) {
        this.orderID = orderID;
        this.amount = amount;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }
}

// Order Processing System
public class OrderProcessingSystem {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("O001", 250.0, LocalDateTime.now().minusHours(3), "PENDING"),
            new Order("O002", 150.0, LocalDateTime.now().minusHours(5), "DELIVERED"),
            new Order("O003", 320.0, LocalDateTime.now(), "PENDING"),
            new Order("O004", 400.0, LocalDateTime.now().minusDays(1), "SHIPPED"),
            new Order("O005", 180.0, LocalDateTime.now().minusHours(2), "DELIVERED")
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime todayStart = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);

        // Calculate total revenue for today's orders
        double totalRevenue = orders.stream()
            .filter(order -> order.getOrderDate().isAfter(todayStart))
            .mapToDouble(Order::getAmount)
            .sum();

        // Get list of all PENDING orders sorted by order date
        List<Order> pendingOrders = orders.stream()
            .filter(order -> order.getStatus().equalsIgnoreCase("PENDING"))
            .sorted(Comparator.comparing(Order::getOrderDate))
            .collect(Collectors.toList());

        // Find the most recent delivered order
        Optional<Order> recentDeliveredOrder = orders.stream()
            .filter(order -> order.getStatus().equalsIgnoreCase("DELIVERED"))
            .max(Comparator.comparing(Order::getOrderDate));

        // Display results
        System.out.println("Total Revenue for Today's Orders: $" + totalRevenue);
        
        System.out.println("\nPending Orders:");
        pendingOrders.forEach(order -> System.out.println(order.getOrderID() + " - " + order.getOrderDate().format(formatter)));
        
        System.out.println("\nMost Recent Delivered Order: " + recentDeliveredOrder
            .map(order -> order.getOrderID() + " - " + order.getOrderDate().format(formatter))
            .orElse("No delivered orders available"));
    }
}