package Day4;

//Custom Checked Exception (InsufficientBalanceException)
class InsufficientBalanceException extends Exception {
 public InsufficientBalanceException(String message) {
     super(message);
 }
}

//Custom Unchecked Exception (InvalidAmountException)
class InvalidAmountException extends RuntimeException {
 public InvalidAmountException(String message) {
     super(message);
 }
}

//Bank Account Class
class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     if (initialBalance < 0) {
         throw new InvalidAmountException("Initial balance cannot be negative.");
     }
     this.balance = initialBalance;
 }

 public void deposit(double amount) {
     if (amount <= 0) {
         throw new InvalidAmountException("Deposit amount must be positive.");
     }
     balance += amount;
     System.out.println("Successfully deposited: " + amount);
 }

 public void withdraw(double amount) throws InsufficientBalanceException {
     if (amount <= 0) {
         throw new InvalidAmountException("Withdrawal amount must be positive.");
     }
     if (amount > balance) {
         throw new InsufficientBalanceException("Insufficient balance! Available balance: " + balance);
     }
     balance -= amount;
     System.out.println("Successfully withdrawn: " + amount);
 }

 public double getBalance() {
     return balance;
 }
}

//Main Class
public class BankingSystem {
 public static void main(String[] args) {
     try {
         BankAccount account = new BankAccount(500);
         System.out.println("Initial Balance: " + account.getBalance());
         
         account.deposit(200);
         System.out.println("Balance after deposit: " + account.getBalance());
         
         account.withdraw(800); // This will throw InsufficientBalanceException
     } catch (InsufficientBalanceException e) {
         System.out.println("Error: " + e.getMessage());
     } catch (InvalidAmountException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }
}
