package daay7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private final String accountName;
    private double balance;
    private final Lock lock = new ReentrantLock(); // Prevents deadlocks

    public BankAccount(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public Lock getLock() {
        return lock;
    }
}

class Transaction implements Runnable {
    private final BankAccount fromAccount;
    private final BankAccount toAccount;
    private final double amount;

    public Transaction(BankAccount fromAccount, BankAccount toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        transferMoney(fromAccount, toAccount, amount);
    }

    private void transferMoney(BankAccount from, BankAccount to, double amount) {
        // **Deadlock Prevention:** Always lock the lower hashCode first
        BankAccount firstLock = from.getName().compareTo(to.getName()) < 0 ? from : to;
        BankAccount secondLock = from.getName().compareTo(to.getName()) < 0 ? to : from;

        firstLock.getLock().lock();
        try {
            secondLock.getLock().lock();
            try {
                if (from.withdraw(amount)) {
                    to.deposit(amount);
                    System.out.println(Thread.currentThread().getName() + " transferred $" + amount + " from " 
                                       + from.getName() + " to " + to.getName());
                } else {
                    System.out.println(Thread.currentThread().getName() + " failed to transfer $" + amount + " (Insufficient funds)");
                }
            } finally {
                secondLock.getLock().unlock();
            }
        } finally {
            firstLock.getLock().unlock();
        }
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        BankAccount accountA = new BankAccount("AccountA", 1000);
        BankAccount accountB = new BankAccount("AccountB", 1000);

        Thread t1 = new Thread(new Transaction(accountA, accountB, 200), "T1");
        Thread t2 = new Thread(new Transaction(accountB, accountA, 300), "T2");
        Thread t3 = new Thread(new Transaction(accountA, accountB, 500), "T3");
        Thread t4 = new Thread(new Transaction(accountB, accountA, 100), "T4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
