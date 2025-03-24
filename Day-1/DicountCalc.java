package Day1; // Make sure your package matches your folder

import java.util.Scanner;

public class DicountCalc {

    // Method to calculate the final price after applying discount
    public static double calculateFinalPrice(double cartValue) {
        double discount = 0;

        if (cartValue > 500) {
            discount = 0.20; // 20% discount
        } else if (cartValue >= 100 && cartValue <= 500) {
            discount = 0.10; // 10% discount
        }

        return cartValue - (cartValue * discount); // 600*0.20=120;600-120=cvalue
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter cart value: ");
        double cartValue = sc.nextDouble();
        sc.close();

        double finalPrice = calculateFinalPrice(cartValue);
        System.out.println("Final price after discount: $" + finalPrice);
    }
}
