package Day4;

import java.util.*;

//Custom Exception for Out of Stock
class OutOfStockException extends Exception {
 public OutOfStockException(String message) {
     super(message);
 }
}

//Custom Exception for Product Not Found
class ProductNotFoundException extends Exception {
 public ProductNotFoundException(String message) {
     super(message);
 }
}

//Product Class
class Product {
 String name;
 int stock;
 double price;

 public Product(String name, int stock, double price) {
     this.name = name;
     this.stock = stock;
     this.price = price;
 }
}

//Order Management System
public class ECommerceSystem {
 private static final Map<String, Product> products = new HashMap<>();
 
 static {
     products.put("Laptop", new Product("Laptop", 10, 800.0));
     products.put("Phone", new Product("Phone", 0, 500.0)); // Out of stock
     products.put("Tablet", new Product("Tablet", 5, 300.0));
 }

 public static void placeOrder(String productName, String quantityStr) {
     try {
         if (!products.containsKey(productName)) {
             throw new ProductNotFoundException("Product not found: " + productName);
         }
         
         int quantity = Integer.parseInt(quantityStr);
         if (quantity <= 0) {
             throw new NumberFormatException("Quantity must be a positive integer.");
         }
         
         Product product = products.get(productName);
         if (product.stock < quantity) {
             throw new OutOfStockException("Product out of stock: " + productName);
         }
         
         product.stock -= quantity;
         System.out.println("Order placed successfully for " + quantity + " " + productName + "(s). Remaining stock: " + product.stock);
     } catch (NumberFormatException | OutOfStockException | ProductNotFoundException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }

 public static void main(String[] args) {
     placeOrder("Laptop", "2"); // Successful order
     placeOrder("Phone", "1"); // Out of stock
     placeOrder("Watch", "1"); // Product not found
     placeOrder("Tablet", "abc"); // Invalid quantity
 }
}
