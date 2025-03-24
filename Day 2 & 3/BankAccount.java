package Day2and3;

public class BankAccount {
    private double balance;
    private String owner;

    // Default constructor
    BankAccount() {
        this(0, "Unknown"); // Calls the third constructor with default values
    }

    // Constructor with balance
    BankAccount(double balance) {
        this(balance, "Unknown"); // Calls the third constructor with default owner name
    }

    // Constructor with balance and owner name
    BankAccount(double balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    void displayAccountInfo() {
        System.out.println("Balance: " + balance + ", Owner: " + owner);
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount(6000);
        BankAccount acc3 = new BankAccount(6000, "John");

        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
        acc3.displayAccountInfo();
    }
}