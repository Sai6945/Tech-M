package Day1;


import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice; // To store user choice

        do {
            // Taking user input
            System.out.print("Enter a number for the multiplication table: ");
            int N = sc.nextInt();

            // ✅ Using a FOR loop (Standard multiplication table)
            System.out.println("\nMultiplication Table of " + N + " (Using FOR Loop):");
            for (int i = 1; i <= 10; i++) {
                System.out.println(N + " x " + i + " = " + (N * i));
            }

            // ✅ Using a WHILE loop (Standard multiplication table)
            System.out.println("\nMultiplication Table of " + N + " (Using WHILE Loop):");
            int i = 1;
            while (i <= 10) {
                System.out.println(N + " x " + i + " = " + (N * i));
                i++;
            }

            // ✅ Using a DO-WHILE loop (Standard multiplication table)
            System.out.println("\nMultiplication Table of " + N + " (Using DO-WHILE Loop):");
            i = 1;
            do {
                System.out.println(N + " x " + i + " = " + (N * i));
                i++;
            } while (i <= 10);

            // ✅ Reverse order table using FOR loop
            System.out.println("\nMultiplication Table of " + N + " in Reverse Order:");
            for (i = 10; i >= 1; i--) {
                System.out.println(N + " x " + i + " = " + (N * i));
            }

            // ✅ Custom range multiplication table using WHILE loop
            System.out.print("\nEnter the start range: ");
            int start = sc.nextInt();
            System.out.print("Enter the end range: ");
            int end = sc.nextInt();

            System.out.println("\nMultiplication Table of " + N + " from " + start + " to " + end + ":");
            i = start;
            while (i <= end) {
                System.out.println(N + " x " + i + " = " + (N * i));
                i++;
            }

            // ✅ Asking the user if they want to generate another table
            System.out.print("\nDo you want to generate another table? (Y/N): ");
            choice = sc.next().charAt(0);
            
        } while (choice == 'Y' || choice == 'y'); // Continue loop if user inputs 'Y' or 'y'

        sc.close(); // Close the scanner
        System.out.println("Program Ended. Thank you!");
    }
}

