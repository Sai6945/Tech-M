package library;  // Package declaration

public class Book {
    private String title;
    private String author;

    // Constructor should be public
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayBookInfo() {  // ✅ Camel case method name
        System.out.println("Title: " + title + ", Author: " + author);
    }
}
