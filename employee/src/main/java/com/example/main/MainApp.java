package com.example.main;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;

public class MainApp {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();

        Employee emp1 = new Employee();
        emp1.setName("John Doe");
        emp1.setDepartment("IT");
        emp1.setSalary(60000);
        dao.saveEmployee(emp1);

        Employee fetchedEmp = dao.getEmployee(1);
        System.out.println("Employee Name: " + fetchedEmp.getName());

        fetchedEmp.setSalary(65000);
        dao.updateEmployee(fetchedEmp);

        dao.deleteEmployee(1);

        dao.getAllEmployees().forEach(emp -> System.out.println(emp.getName()));
    }
}