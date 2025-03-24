package Day1;
import java.util.Scanner;

public class IntegerCompression {
    private static final int KEY = 759601430; // XOR key for encoding and decoding

    // Method to encode an integer
    public static int encode(int number) {
        return number ^ KEY; // XOR operation for encoding
    }

    // Method to decode an integer
    public static int decode(int encodedNumber) {
        return encodedNumber ^ KEY; // XOR again to get the original number
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        sc.close();

        int encoded = encode(n);
        int decoded = decode(encoded);

        System.out.println("Original: " + n);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decoded);
    }
}
