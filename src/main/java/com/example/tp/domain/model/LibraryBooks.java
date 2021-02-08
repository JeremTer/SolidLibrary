package com.example.tp.domain.model;

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

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void showBook(Book book) {
        System.out.println(book);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Book book : books) {
            str.append(book.toString()).append("\n");
        }
        return str.toString();
    }
}
