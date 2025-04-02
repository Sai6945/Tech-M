package Day9;

import java.sql.*;

public class EmployeeDatabase {

    // JDBC URL, username, and password for MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/employee_db"; // Make sure your DB is correctly set up
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

    // Add a new employee securely using PreparedStatement
    public static void addEmployee(int employeeId, String name, String position, double salary) {
        String query = "INSERT INTO employees (employee_id, name, position, salary) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, employeeId);
            stmt.setString(2, name);
            stmt.setString(3, position);
            stmt.setDouble(4, salary);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve employee details by ID using a secure parameterized query
    public static void getEmployeeById(int employeeId) {
        String query = "SELECT * FROM employees WHERE employee_id = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("employee_id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");

                System.out.println("Employee ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Position: " + position);
                System.out.println("Salary: $" + salary);
            } else {
                System.out.println("Employee not found with ID: " + employeeId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update employee salary securely using PreparedStatement
    public static void updateEmployeeSalary(int employeeId, double newSalary) {
        String query = "UPDATE employees SET salary = ? WHERE employee_id = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, newSalary);
            stmt.setInt(2, employeeId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee salary updated successfully!");
            } else {
                System.out.println("Employee with ID " + employeeId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete employee by ID using a secure parameterized query
    public static void deleteEmployee(int employeeId) {
        String query = "DELETE FROM employees WHERE employee_id = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, employeeId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee with ID " + employeeId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all employees from the database
    public static void getAllEmployees() {
        String query = "SELECT * FROM employees";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");

                System.out.println("Employee ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Position: " + position);
                System.out.println("Salary: $" + salary);
                System.out.println("------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // Add a new employee
        addEmployee(1, "John Doe", "Software Engineer", 95000.00);
        
        // Retrieve employee details by ID
        getEmployeeById(1);

        // Update employee salary
        updateEmployeeSalary(1, 100000.00);

        // Retrieve all employees
        getAllEmployees();

        // Delete employee by ID
        deleteEmployee(1);
    }
}
