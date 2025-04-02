package Day8;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// BankAccount.java
class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance -= amount;
    }

    // Get the balance
    public double getBalance() {
        return balance;
    }
}

// Custom Exception: InsufficientFundsException.java
class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// JUnit Test Class: BankAccountTest.java
public class BankAccountTest {

    // Test valid deposit
    @Test
    public void testDepositValidAmount() {
        BankAccount account = new BankAccount("John Doe", 1000);
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    // Test deposit with invalid amount (negative deposit)
    @Test
    public void testDepositInvalidAmount() {
        BankAccount account = new BankAccount("John Doe", 1000);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-500);
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }

    // Test valid withdrawal
    @Test
    public void testWithdrawValidAmount() {
        BankAccount account = new BankAccount("John Doe", 1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance());
    }

    // Test withdrawal exceeding balance (insufficient funds)
    @Test
    public void testWithdrawExceedingBalance() {
        BankAccount account = new BankAccount("John Doe", 1000);
        InsufficientFundsException exception = assertThrows(InsufficientFundsException.class, () -> {
            account.withdraw(1500);
        });
        assertEquals("Insufficient funds for withdrawal", exception.getMessage());
    }

    // Test invalid withdrawal (negative withdrawal amount)
    @Test
    public void testWithdrawInvalidAmount() {
        BankAccount account = new BankAccount("John Doe", 1000);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-500);
        });
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }

    // Parameterized test for different deposit values
    @ParameterizedTest
    @ValueSource(doubles = {100.0, 200.5, 300.75})
    public void testDepositMultipleValues(double depositAmount) {
        BankAccount account = new BankAccount("John Doe", 500);
        account.deposit(depositAmount);
        assertEquals(500 + depositAmount, account.getBalance());
    }

    // Parameterized test for multiple withdrawal values
    @ParameterizedTest
    @ValueSource(doubles = {100.0, 200.0, 300.0})
    public void testWithdrawMultipleValues(double withdrawAmount) {
        BankAccount account = new BankAccount("John Doe", 1000);
        account.withdraw(withdrawAmount);
        assertEquals(1000 - withdrawAmount, account.getBalance());
    }

    // Test creating an account with negative balance
    @Test
    public void testNegativeInitialBalance() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("John Doe", -500);
        });
        assertEquals("Initial balance cannot be negative", exception.getMessage());
    }
}
