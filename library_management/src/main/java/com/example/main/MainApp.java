package com.example.main;

import com.example.dao.LibraryDAO;
import com.example.model.Author;
import com.example.model.Book;

public class MainApp {
    public static void main(String[] args) {
        LibraryDAO dao = new LibraryDAO();

        Author author = new Author();
        author.setName("J.K. Rowling");
        dao.saveAuthor(author);

        Book book = new Book();
        book.setTitle("Harry Potter");
        book.setAuthor(author);
        dao.saveBook(book);

        dao.getAllBooks().forEach(b -> System.out.println("Book: " + b.getTitle() + ", Author: " + b.getAuthor().getName()));
    }
}