package Day6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

// Employee Class
class Employee {
    private final int id;
    private final String name;
    private final Optional<LocalDateTime> lastLogin;

    public Employee(int id, String name, LocalDateTime lastLogin) {
        this.id = id;
        this.name = name;
        this.lastLogin = Optional.ofNullable(lastLogin);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<LocalDateTime> getLastLogin() {
        return lastLogin;
    }
}

// Employee Attendance Tracker
public class EmployeeAttendanceTracker {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", LocalDateTime.now().minusDays(10)),
            new Employee(2, "Bob", LocalDateTime.now().minusDays(5)),
            new Employee(3, "Charlie", LocalDateTime.now().minusDays(15)),
            new Employee(4, "David", null), // Missing login record
            new Employee(5, "Eve", LocalDateTime.now().minusDays(3))
        );

        // Find employees who haven't logged in for the past 7 days
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);
        List<Employee> inactiveEmployees = employees.stream()
            .filter(e -> e.getLastLogin().map(login -> login.isBefore(sevenDaysAgo)).orElse(true))
            .collect(Collectors.toList());

        // Sort employees by last login date (oldest first)
        List<Employee> sortedEmployees = employees.stream()
            .sorted(Comparator.comparing(e -> e.getLastLogin().orElse(LocalDateTime.MIN)))
            .collect(Collectors.toList());

        // DateTimeFormatter for output
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("Employees who haven't logged in for 7+ days:");
        inactiveEmployees.forEach(e -> System.out.println(e.getName() + " - " + e.getLastLogin()
            .map(login -> login.format(formatter)).orElse("No Record")));

        System.out.println("\nEmployees sorted by last login:");
        sortedEmployees.forEach(e -> System.out.println(e.getName() + " - " + e.getLastLogin()
            .map(login -> login.format(formatter)).orElse("No Record")));
    }
}
