package Day4;

import java.io.*;
import java.util.*;

// Custom Checked Exception (EmptyFileException)
class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}

public class FileProcessor {
    public static void main(String[] args) {
        String fileName = "src/Day4/numbers.txt";
        
        try {
            int sum = processFile(fileName);
            System.out.println("Sum of numbers: " + sum);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in file - " + e.getMessage());
        } catch (EmptyFileException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static int processFile(String fileName) throws IOException, EmptyFileException {
        int sum = 0;
        boolean isEmpty = true;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                isEmpty = false;
                sum += Integer.parseInt(line.trim());
            }
        }
        
        if (isEmpty) {
            throw new EmptyFileException("The file is empty.");
        }
        
        return sum;
    }
}
