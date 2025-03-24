import java.io.*;
import java.util.*;

public class SecureUserDataStorage {
    private static final String FILE_NAME = "users.txt";
    private static final Map<String, String> users = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        loadUsers();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        if (users.containsKey(email)) {
            System.out.println("User already exists!");
        } else {
            saveUser(name, email, password);
            System.out.println("User registered successfully!");
        }
    }
    
    private static void loadUsers() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            users.put(parts[1], parts[2]);
        }
        br.close();
    }
    
    private static void saveUser(String name, String email, String password) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
        bw.write(name + "," + email + "," + password + "\n");
        bw.close();
    }
}
