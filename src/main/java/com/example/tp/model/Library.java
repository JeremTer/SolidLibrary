package com.example.tp.model;

public class Library {
    private final LibraryBooks libraryBooks;

    public Library(LibraryBooks libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public void addBook(Book book) {
        if (book != null && book.isCorrect()) {
            Book bookExists = libraryBooks.findBook(book);
            if (bookExists == null) {
                libraryBooks.addBook(book);
            }
        }
    }

    public void showAllBooks() {
        libraryBooks.showAllBooks();
    }

    public void showBook(Book book) {
        Book bookToShow = libraryBooks.findBook(book);
        if (bookToShow != null) {
            System.out.println(bookToShow);
        }
    }

    public void borrowBook(Book book) {
        if (isBookAvailable(book)) {
            book.borrow();
        }
    }

    private boolean isBookAvailable(Book bookToFind) {
        Book book = libraryBooks.findBook(bookToFind);
        return book != null && book.isAvailable();
    }

    public void renderBook(Book book) {
        if (book != null && book.isCorrect()) {
            Book borrowedBook = libraryBooks.findBook(book);
            if (borrowedBook != null) {
                book.render();
            }
        }
    }

}
