package Day1;
import java.util.Scanner;

public class ImageProcessor {
    public static int convertToGrayscale(int red, int green, int blue) {
        // Approximate grayscale formula: 0.3R + 0.59G + 0.11B
        // Using bitwise shift for integer division to improve efficiency
        int grayscale = (red * 77 + green * 150 + blue * 29) >> 8; // Dividing by 256
        return grayscale;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter red value (0-255): ");
        int red = scanner.nextInt();
        System.out.print("Enter green value (0-255): ");
        int green = scanner.nextInt();
        System.out.print("Enter blue value (0-255): ");
        int blue = scanner.nextInt();
        scanner.close();

        int grayscale = convertToGrayscale(red, green, blue);
        System.out.println("Grayscale value: " + grayscale);
    }
}
