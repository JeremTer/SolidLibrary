package com.example.tp.domain.model;

public class Library {
    private final LibraryBooks libraryBooks;

    public Library(LibraryBooks libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBook(Book book) {
        return libraryBooks.findBook(book);
    }

    public void addBook(Book book) {
        libraryBooks.addBook(book);
    }

    public void showAllBooks() {
        libraryBooks.showAllBooks();
    }

    public void showBook(Book book) {
        libraryBooks.showBook(book);
    }

}
