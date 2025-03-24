import java.util.Scanner;
class ReverseBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        int rev = Integer.reverse(num);
        System.out.println("Reversed Binary: " + Integer.toBinaryString(rev));
        System.out.println("Equivalent Decimal: " + rev);
    }
}