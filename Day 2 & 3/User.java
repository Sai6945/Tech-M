package Day2and3;

public class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        setPassword(password); // Use setter to enforce password rules
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for password with security criteria
    public void setPassword(String password) {
        if (password.length() >= 8) {
            this.password = password;
            System.out.println("Password set successfully.");
        } else {
            System.out.println("Password must be at least 8 characters long.");
        }
    }

    public void displayDetails() {
        System.out.println("Username is: " + username);
    }

    public static void main(String[] args) {
        User u = new User("John", "hi147875457");
        u.displayDetails();
        u.setPassword("short"); // Attempt to set an invalid password
    }
}
