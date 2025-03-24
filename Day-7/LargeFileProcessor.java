import java.io.*;

public class LargeFileProcessor {
    private static final String INPUT_FILE = "data.txt";
    private static final String OUTPUT_FILE = "output.txt";
    
    public static void main(String[] args) {
        File file = new File(INPUT_FILE);
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
             BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toUpperCase() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}