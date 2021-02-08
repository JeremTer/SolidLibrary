package com.example.tp.model;

import com.example.tp.model.status.Status;

public class Person {

    private final Status status;
    private final Library library;
    private final LibraryBooks borrowedBooks;

    public Person(Status status, Library library) {
        this.status = status;
        this.library = library;
        this.borrowedBooks = new LibraryBooks();
    }

    public void seeBook(Book book) {
        library.showBook(book);
    }

    public void borrowBook(Book book) {
        if (this.status.isAbleToBorrowBook()
                && this.status.borrowBookNumberLimitAtTheSameTime() < this.borrowedBooks.booksNumber()) {
            library.borrowBook(book);
        }
    }

    public void addBook(Book book) {
        if (this.status.isAbleToAddNewBook()) {
            library.addBook(book);
        }
    }

    public void renderBook(Book book) {
        if (this.status.isAbleToBorrowBook()) {
            library.renderBook(book);
        }
    }

    public void seeBorrowedBooks() {
        this.borrowedBooks.showAllBooks();
    }

    public void seeAllLibraryBooks() {
        library.showAllBooks();
    }
}
