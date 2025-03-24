package Day2and3;
import java.util.*;

class Employee {
    double CalculateSalary() {
        return 50000; // Base salary
    }
}

class Manager extends Employee {
    private double bonus;
    
    Manager(double bonus) {
        this.bonus = bonus;
    }
    
    @Override
    double CalculateSalary() {
        return super.CalculateSalary() + bonus;
    }
}

public class SalarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bonus: ");
        double bonus = sc.nextDouble();
        
        Employee e = new Employee();
        Manager m = new Manager(bonus);
        
        System.out.println("Base salary: " + e.CalculateSalary());
        System.out.println("Base salary + Bonus: " + m.CalculateSalary());
        
        sc.close();
    }
}
