// EmployeeDatabase.java
import java.io.*;
import java.util.*;

public class EmployeeDatabase {
    private static final String FILE_NAME = "employees.dat";
    
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing employees found.");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        employees.add(name);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Employee added successfully.");
    }
}
