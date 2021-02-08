package com.example.tp.domain.model.person;

import com.example.tp.domain.model.Book;
import com.example.tp.domain.model.LibraryBooks;
import com.example.tp.domain.model.person.ability.PersonAbilities;

public class Person {

    private final PersonAbilities personAbilities;
    private LibraryBooks borrowedBooks;
    private final String name;

    public Person(PersonAbilities personAbilities, String name) {
        this.personAbilities = personAbilities;
        this.name = name;
        this.borrowedBooks = new LibraryBooks();
    }

    public String getName() {
        return name;
    }

    public boolean isAbleToAddNewBook() {
        return personAbilities.isAbleToAddNewBook();
    }

    public boolean isAbleToBorrowBook() {
        return personAbilities.isAbleToBorrowBook();
    }

    public Integer borrowBookTimeLimitInWeek() {
        return personAbilities.borrowBookTimeLimitInWeek();
    }

    public Integer borrowBookNumberLimitAtTheSameTime() {
        return personAbilities.borrowBookNumberLimitAtTheSameTime();
    }

    public Integer borrowedBooksNumber() {
        return borrowedBooks.booksNumber();
    }

    public void borrowBook(Book book) {
        borrowedBooks.addBook(book);
    }

    public void renderBook(Book book) {
        borrowedBooks.removeBook(book);
    }

    public Book findBorrowedBook(Book book) {
        return borrowedBooks.findBook(book);
    }

    public LibraryBooks borrowedBooks() {
        return borrowedBooks;
    }

    public void loadBorrowedBooks(LibraryBooks books) {
        borrowedBooks = books;
    }

    public void showBorrowedBooks() {
        borrowedBooks.showAllBooks();
    }
}
