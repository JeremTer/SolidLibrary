package com.example.tp.domain.model.person;

import com.example.tp.domain.model.Book;
import com.example.tp.domain.model.LibraryBooks;
import com.example.tp.domain.model.person.ability.PersonAbilities;

public class Person {

    private final PersonAbilities personAbilities;
    private final LibraryBooks borrowedBooks;

    public Person(PersonAbilities personAbilities) {
        this.personAbilities = personAbilities;
        this.borrowedBooks = new LibraryBooks();
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
        book.borrow();
        borrowedBooks.addBook(book);
    }

    public void renderBook(Book book) {
        book.render();
        borrowedBooks.removeBook(book);
    }

    public Book findBorrowedBook(Book book) {
        return borrowedBooks.findBook(book);
    }
}
