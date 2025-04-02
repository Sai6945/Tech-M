package Day9;

import java.sql.*;

public class BatchProcessing{

    // JDBC URL, username, and password for MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce_db"; // Update to your DB URL
    private static final String USER = "root"; // Update with your MySQL username
    private static final String PASSWORD = "password"; // Update with your MySQL password

    // Establish connection to the database
    public static Connection connect() throws SQLException {
        try {
            // Register MySQL JDBC driver (if necessary)
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: Unable to connect to the database.");
            e.printStackTrace();
            throw new SQLException("Database connection error");
        }
    }

    // Batch insert multiple records into the orders table
    public static void insertOrdersInBatch() {
        String query = "INSERT INTO orders (order_id, customer_name, product_name, quantity, price) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Disable auto-commit for batch processing
            conn.setAutoCommit(false);

            // Add multiple orders to the batch
            stmt.setInt(1, 1);
            stmt.setString(2, "John Doe");
            stmt.setString(3, "Laptop");
            stmt.setInt(4, 2);
            stmt.setDouble(5, 1000.00);
            stmt.addBatch(); // Add to batch

            stmt.setInt(1, 2);
            stmt.setString(2, "Jane Smith");
            stmt.setString(3, "Smartphone");
            stmt.setInt(4, 3);
            stmt.setDouble(5, 600.00);
            stmt.addBatch(); // Add to batch

            stmt.setInt(1, 3);
            stmt.setString(2, "David Johnson");
            stmt.setString(3, "Tablet");
            stmt.setInt(4, 1);
            stmt.setDouble(5, 350.00);
            stmt.addBatch(); // Add to batch

            // Execute batch and commit the transaction
            int[] results = stmt.executeBatch();
            conn.commit();

            // Print results of batch execution
            System.out.println("Batch insert successful! Rows inserted: " + results.length);
        } catch (SQLException e) {
            System.out.println("Error during batch insertion");
            e.printStackTrace();
            try {
                // Rollback transaction in case of error
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Main method to test batch insert
    public static void main(String[] args) {
        insertOrdersInBatch();  // Insert data in batch
    }
}
