package com.example.tp.model;

import java.util.ArrayList;
import java.util.List;

public class LibraryBooks {

    private final List<Book> books;

    public LibraryBooks() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void showAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Integer booksNumber() {
        return books.size();
    }

    public Book findBook(Book bookToFind) {
        for (Book libraryBook : books) {
            if (libraryBook.equals(bookToFind)) {
                return bookToFind;
            }
        }
        return null;
    }
}
