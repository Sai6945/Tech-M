package Day4;

import java.util.Random;

//Custom Exception for Negative Numbers
class NegativeNumberException extends Exception {
 public NegativeNumberException(String message) {
     super(message);
 }
}

//Shared Data Class
class SharedData {
 int[] numbers = new int[10];
}

//Thread to Generate Random Numbers
class NumberGenerator extends Thread {
 private final SharedData data;
 private final Random random = new Random();

 public NumberGenerator(SharedData data) {
     this.data = data;
 }

 @Override
 public void run() {
     System.out.println("Generating numbers...");
     for (int i = 0; i < data.numbers.length; i++) {
         data.numbers[i] = random.nextInt(100) - 50; // Generates numbers between -50 and 49
     }
 }
}

//Thread to Compute Square Roots
class SquareRootCalculator extends Thread {
 private final SharedData data;

 public SquareRootCalculator(SharedData data) {
     this.data = data;
 }

 @Override
 public void run() {
     System.out.println("Calculating square roots...");
     for (int num : data.numbers) {
         try {
             if (num < 0) {
                 throw new NegativeNumberException("Negative number encountered: " + num);
             }
             System.out.println("Square root of " + num + " is: " + Math.sqrt(num));
         } catch (NegativeNumberException e) {
             System.out.println("Error: " + e.getMessage());
         } finally {
             System.out.println("Processed number: " + num);
         }
     }
 }
}

//Main Class
public class MultiThreadedApp {
 public static void main(String[] args) {
     SharedData data = new SharedData();
     NumberGenerator generator = new NumberGenerator(data);
     SquareRootCalculator calculator = new SquareRootCalculator(data);
     
     generator.start();
     try {
         generator.join(); // Ensures numbers are generated before calculation
     } catch (InterruptedException e) {
         System.out.println("Thread interrupted: " + e.getMessage());
     }
     
     calculator.start();
     try {
         calculator.join();
     } catch (InterruptedException e) {
         System.out.println("Thread interrupted: " + e.getMessage());
     }
     
     System.out.println("Execution completed.");
 }
}