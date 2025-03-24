import java.util.Scanner;
class PowerOfTwo {
    public static boolean isPowerOfTwo(int num) {
        return (num > 0) && (num & (num - 1)) == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println(num + " is " + (isPowerOfTwo(num) ? "a power of two." : "not a power of two."));
    }
}