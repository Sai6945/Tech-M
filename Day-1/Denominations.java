package Day1;
import java.util.Scanner;

public class Denominations {
    
    public static void withdrawCash(int amount) {
        // Check if amount is a multiple of 100
        if (amount % 100 != 0) {
            System.out.println("Error: Amount must be a multiple of 100.");
            return;
        }

        // Denominations
        int note2000 = amount / 2000;
        amount %= 2000; // Remaining amount after dispensing ₹2000 notes

        int note500 = amount / 500;
        amount %= 500; // Remaining amount after dispensing ₹500 notes

        int note100 = amount / 100;
        
        // Display the result
        System.out.println("Cash Dispensed:");
        if (note2000 > 0) System.out.println(note2000 + " x ₹2000");
        if (note500 > 0) System.out.println(note500 + " x ₹500");
        if (note100 > 0) System.out.println(note100 + " x ₹100");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        int amount = sc.nextInt();
        sc.close();

        withdrawCash(amount);
    }
}


