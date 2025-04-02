package Day7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatLogger {
    private static final String BASE_FILE_NAME = "chat_logs.txt";
    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 5MB

    public static void main(String[] args) {
        logMessage("User1: Hello!");
        logMessage("User2: Hi there!");
        logMessage("User1: How are you?");

        System.out.println("Searching for 'Hello':");
        searchMessages("Hello");
    }

    private static void logMessage(String message) {
        try {
            String fileName = getLogFileName();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                writer.write(timestamp + " - " + message);
                writer.newLine();
            }
            System.out.println("Message logged: " + message);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    private static String getLogFileName() throws IOException {
        File file = new File(BASE_FILE_NAME);
        if (file.exists() && file.length() >= MAX_FILE_SIZE) {
            int index = 1;
            while (Files.exists(Paths.get("chat_logs_" + index + ".txt"))) {
                index++;
            }
            Files.move(file.toPath(), Paths.get("chat_logs_" + index + ".txt"));
        }
        return BASE_FILE_NAME;
    }

    private static void searchMessages(String keyword) {
        try (BufferedReader reader = new BufferedReader(new FileReader(BASE_FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
        }
    }
}
