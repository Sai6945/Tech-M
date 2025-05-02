// Importing Scanner class to read input from user

import java.util.*;


// Declaring a class named Library
public class Library {
// Declaring an array of objects of class Book and a variable count
Book[] books;
public int count;

// Constructor of the class Library
public Library() {
    // Initializing the array with size 90 and count with 0
    books = new Book[90];
    count = 0;
}

// A method to return the number of books in the library
public int countBooks() {
    return count;
}

// A method to find a book with a given serial number and return its index, or -1 if not found
public int findBook(int sNo) {
    for (int i = 0; i < count; i++) {
        if (books[i].getsNo() == sNo) {
            return i;
        }
    }
    return -1;
}

// A method to get a book at a specific index, returns null if out of bounds
public Book getBook(int index) {
    if (index >= 0 && index <= count) {
        return books[index];
    }
    return null;
}

// A method to add a book to the library, returns true if added successfully, false otherwise
public boolean addBook(Book b) {
    if (count < books.length && findBook(b.getsNo()) == -1) {
        books[count] = b;
        count++;
        return true;
    }
    return false;

}

// A method to remove a book from the library, returns true if removed successfully, false otherwise
public boolean removeBook(Book b){
    int index = findBook(b.getsNo());
    if (index != -1) {
        for (int i = index; i < (count - 1); i++) {
            books[i] = books[i+1]; // Shift left.
        }
        count--;
        return true;
    }
    return false;
}

// A method to print information of all books in the library
public void getAllBook() {
    System.out.println("Total books : "+count + "\r\n");
    System.out.println("All the book in the system are: " + "\r\n");

    for(int i = 0; i < count; i++){
        System.out.println(books[i]);
        System.out.println("\r\n");
    }

}

// A method to display the main menu of the library system
public void displayMainMenu(){
    System.out.println("******************************");
    System.out.println("         Library Menu");
    System.out.println("1: Add a book.");
    System.out.println("2: Get a book information.");
    System.out.println("3: Update a book information.");
    System.out.println("4: Delete the book.");
    System.out.println("5: Print all books.");
    System.out.println("******************************" + "\r\n");
}
}