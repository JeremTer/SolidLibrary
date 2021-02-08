package com.example.tp.usecase;

import com.example.tp.domain.model.Book;
import com.example.tp.domain.model.Library;
import com.example.tp.domain.model.person.Person;

public class BorrowBook {

    private final Library library;
    private final Person person;

    public BorrowBook(Library library, Person person) {
        this.person = person;
        this.library = library;
    }

    public void execute(Book book) {
        if (book != null && book.isCorrect()) {
            Book bookToBorrow = library.findBook(book);
            if (bookToBorrow != null && book.isAvailable()
                    && person.isAbleToBorrowBook()
                    && person.borrowBookNumberLimitAtTheSameTime() > person.borrowedBooksNumber()) {
                person.borrowBook(book);
            }
        }
    }

}
