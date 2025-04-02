package Day8;

public class Fibonacci {

    // Recursive Fibonacci method with logging
    public static int fibonacci(int n) {
        // Log the current value of n to track recursion
        System.out.println("fibonacci(" + n + ") called");

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        // Bug: The next line should be "fibonacci(n-1) + fibonacci(n-2)"
        int result = fibonacci(n - 1) * fibonacci(n - 2);  // Incorrect recursive logic
        System.out.println("fibonacci(" + n + ") = " + result);  // Log the result
        return result;
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println("Fibonacci of " + number + " is: " + fibonacci(number));
    }
}
