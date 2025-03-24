package Day5;

import java.util.*;

//Employee class
class Employee {
 int id;
 String name;
 double salary;
 String department;

 public Employee(int id, String name, double salary, String department) {
     this.id = id;
     this.name = name;
     this.salary = salary;
     this.department = department;
 }

 @Override
 public boolean equals(Object obj) {
     if (this == obj) return true;
     if (obj == null || getClass() != obj.getClass()) return false;
     Employee employee = (Employee) obj;
     return id == employee.id;
 }

 @Override
 public int hashCode() {
     return Objects.hash(id);
 }

 @Override
 public String toString() {
     return id + " - " + name + " - " + salary + " - " + department;
 }
}

public class EmployeeManagement {
 List<Employee> employeeList = new ArrayList<>();
 Set<Employee> employeeSet = new HashSet<>();
 Map<String, List<Employee>> departmentMap = new HashMap<>();

 public void addEmployee(Employee emp) {
     if (employeeSet.add(emp)) {
         employeeList.add(emp);
         departmentMap.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
     }
 }

 public Employee searchEmployeeById(int id) {
     for (Employee emp : employeeList) {
         if (emp.id == id) return emp;
     }
     return null;
 }

 public void displayEmployees() {
     for (Employee emp : employeeList) {
         System.out.println(emp);
     }
 }

 public static void main(String[] args) {
     EmployeeManagement em = new EmployeeManagement();
     em.addEmployee(new Employee(1, "Alice", 50000, "HR"));
     em.addEmployee(new Employee(2, "Bob", 70000, "IT"));
     em.addEmployee(new Employee(3, "Charlie", 60000, "Finance"));

     System.out.println("\nAll Employees:");
     em.displayEmployees();

     System.out.println("\nSearching for Employee with ID 2:");
     System.out.println(em.searchEmployeeById(2));
 }
}
