package com.example.tp.usecase;

import com.example.tp.domain.model.person.Person;
import com.example.tp.domain.service.BookGetter;

public class SeeBorrowedBooks {
    private final BookGetter bookGetter;
    private final Person person;

    public SeeBorrowedBooks(BookGetter bookGetter, Person person) {
        this.bookGetter = bookGetter;
        this.person = person;
    }

    public void execute() {
        if (person.isAbleToBorrowBook()) {
            person.loadBorrowedBooks(bookGetter.getPersonBorrowedBooks(person));
            person.showBorrowedBooks();
        }
    }
}
