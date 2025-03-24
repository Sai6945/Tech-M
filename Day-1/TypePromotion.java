import java.util.Scanner;
class TypePromotion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int a = sc.nextInt();
        System.out.print("Enter a character: ");
        char b = sc.next().charAt(0);
        System.out.print("Enter a double: ");
        double c = sc.nextDouble();
        double result = a + b * c;
        System.out.println("Result of (a + b * c) = " + result);
    }
}
