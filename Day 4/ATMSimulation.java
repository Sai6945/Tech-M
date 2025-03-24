package Day4;

import java.util.Random;

//Custom Exceptions
class NetworkException extends Exception {
 public NetworkException(String message) {
     super(message);
 }
}

class InvalidPINException extends Exception {
 public InvalidPINException(String message) {
     super(message);
 }
}

class InsufficientFundsException extends Exception {
 public InsufficientFundsException(String message) {
     super(message);
 }
}

class DailyLimitExceededException extends Exception {
 public DailyLimitExceededException(String message) {
     super(message);
 }
}

//ATM Simulation Class
class ATM {
 private static final int CORRECT_PIN = 1234;
 private static final double DAILY_LIMIT = 1000;
 private double balance = 500; // Initial balance

 public void withdraw(int pin, double amount) {
     try {
         checkNetwork(); // Simulate network connectivity check
         
         try {
             if (pin != CORRECT_PIN) {
                 throw new InvalidPINException("Invalid PIN entered.");
             }
             if (amount > balance) {
                 throw new InsufficientFundsException("Insufficient balance.");
             }
             if (amount > DAILY_LIMIT) {
                 throw new DailyLimitExceededException("Withdrawal limit exceeded.");
             }
             
             balance -= amount;
             System.out.println("Withdrawal successful. Remaining balance: " + balance);
         } catch (InvalidPINException | InsufficientFundsException | DailyLimitExceededException e) {
             System.out.println("Transaction Failed: " + e.getMessage());
         }
     } catch (NetworkException e) {
         System.out.println("Network Error: " + e.getMessage());
     }
 }

 private void checkNetwork() throws NetworkException {
     Random random = new Random();
     if (random.nextBoolean()) { // Simulate random network failure
         throw new NetworkException("Network connectivity issue. Please try again later.");
     }
 }
}

//Main Class
public class ATMSimulation {
 public static void main(String[] args) {
     ATM atm = new ATM();
     atm.withdraw(1234, 300); // Successful transaction
     atm.withdraw(4321, 300); // Invalid PIN
     atm.withdraw(1234, 600); // Insufficient funds
     atm.withdraw(1234, 1200); // Exceeds daily limit
 }
}
