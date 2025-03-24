

package Day2and3;

import java.util.Scanner;

class Authenticator {
    private final String correctPassword = "admin123"; // Hardcoded password

    // Member Inner Class
    private class Validator {
        public boolean validate(String password) {
            return password.equals(correctPassword);
        }
    }

    public void login(String password) {
        Validator validator = new Validator(); // Inner class instance
        if (validator.validate(password)) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Incorrect Password");
        }
    }
}

public class AuthenticationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter password: ");
        String userPassword = scanner.nextLine();
        
        Authenticator auth = new Authenticator();
        auth.login(userPassword);  // Check password
        
        scanner.close();
    }
}

