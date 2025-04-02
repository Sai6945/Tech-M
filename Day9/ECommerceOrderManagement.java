package Day9;

import java.sql.*;

public class ECommerceOrderManagement {

    // JDBC URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Establish connection to the database
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Add a new order
    public static void addOrder(int orderId, String customerName, String productName, int quantity, double price) {
        String query = "INSERT INTO orders (order_id, customer_name, product_name, quantity, price) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            stmt.setString(2, customerName);
            stmt.setString(3, productName);
            stmt.setInt(4, quantity);
            stmt.setDouble(5, price);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Order added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update an order
    public static void updateOrder(int orderId, String productName, int quantity, double price) {
        String query = "UPDATE orders SET product_name = ?, quantity = ?, price = ? WHERE order_id = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, productName);
            stmt.setInt(2, quantity);
            stmt.setDouble(3, price);
            stmt.setInt(4, orderId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Order updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete an order
    public static void deleteOrder(int orderId) {
        String query = "DELETE FROM orders WHERE order_id = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Order deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get an order by ID
    public static void getOrderById(int orderId) {
        String query = "SELECT * FROM orders WHERE order_id = ?";
        
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("order_id");
                String customerName = rs.getString("customer_name");
                String productName = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                System.out.println("Order ID: " + id);
                System.out.println("Customer Name: " + customerName);
                System.out.println("Product Name: " + productName);
                System.out.println("Quantity: " + quantity);
                System.out.println("Price: $" + price);
            } else {
                System.out.println("Order not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all orders
    public static void getAllOrders() {
        String query = "SELECT * FROM orders";
        
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("order_id");
                String customerName = rs.getString("customer_name");
                String productName = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                System.out.println("Order ID: " + id);
                System.out.println("Customer Name: " + customerName);
                System.out.println("Product Name: " + productName);
