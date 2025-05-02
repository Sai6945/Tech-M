
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Create a new Library object
        Library library = new Library();

        // Repeat the main menu until the user quits the program
        do {
            // Display the main menu
            library.displayMainMenu();

            // Get the user's menu choice
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            // Add a book to the library
            if (choice == 1) {
                // Create a new Book object
                Book book = new Book();
                // Display the book menu and get the book's details from the user
                book.bookMenu();
                // Add the book to the library
                library.addBook(book);

            // Find a book in the library
            } else if (choice == 2) {
                // Ask the user for the serial number of the book they want to find
                System.out.println("Enter the books serial Number that you want to find : ");
                int userChoice = sc.nextInt();
                // Search for the book in the library and get its index
                int indexUser = library.findBook(userChoice);
                // Print the details of the book with the given serial number
                System.out.println("The book with the given Serial Number is: " + "\r\n" + library.getBook(library.findBook(userChoice)));

            // Update a book in the library
            } else if (choice == 3) {
                // Ask the user for the serial number of the book they want to update
                System.out.println("Enter the books serial Number that you want to Update : ");
                int userChoice = sc.nextInt();
                // Get the Book object from the library using its serial number
                Book book = library.getBook(library.findBook(userChoice));
                // Display the update menu for the book and get the user's update choice
                book.userUpdateDisplay();
                System.out.println("What do you want to update. ");
                int updateUserChoice = sc.nextInt();
                // Update the book's serial number
                if (updateUserChoice == 1) {
                    System.out.println("Enter the new serial number for the book:  ");
                    int newsNo = sc.nextInt();
                    book.setsNo(newsNo);
                // Update the book's name
                } else if (updateUserChoice == 2) {
                    System.out.println("Enter the New Book Name: ");
                    String newBookName = sc.next();
                    book.setBookName(newBookName);
                // Update the book's author
                } else if (updateUserChoice == 3) {
                    System.out.println("Enter the new Author Name: ");
                    String newAuthorName = sc.next();
                    book.setAuthorName(newAuthorName);
                }
                // Print the updated book details
                System.out.println("The updated Book is : " + library.getBook(userChoice));

            // Remove a book from the library
            } else if (choice == 4) {
                // Ask the user for the serial number of the book they want to delete
                System.out.println("Enter the books serial Number that you want to Delete : ");
                int userChoice = sc.nextInt();
                // Get the Book object from the library using its serial number
                Book book = library.getBook(library.findBook(userChoice));
                // Remove the book from the library
                library.removeBook(book);

            // List all books in the library
            } else if(choice == 5) {
                library.getAllBook();
            }
        } while (true); // Keep repeating the main menu until the program 
                        // is terminated by the user. This is achieved by 
                        // using a while loop with a condition of true. 
                        // The loop will keep running until the user 
                        // terminates the program by manually ending it or 
                        // entering a specific input to indicate program termination.
  }
}