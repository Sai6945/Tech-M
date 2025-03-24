package Day1;
import java.util.Scanner;
public class ReverseBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        scanner.close();
        
        int reversedNum = reverseBits(num);
        
        System.out.println("Reversed Binary: " + Integer.toBinaryString(reversedNum));
        System.out.println("Equivalent Decimal: " + reversedNum);
    }
    
    public static int reverseBits(int num) {
        int result = 0;
        for (int i = 0; i < 32; i++) { // Assuming 32-bit integer
            result <<= 1; // Left shift result
            result |= (num & 1); // Get the last bit of num and set it in result
            num >>= 1; // Right shift num
        }
        return result;
    }
}
