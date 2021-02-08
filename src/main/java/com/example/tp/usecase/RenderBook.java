package com.example.tp.usecase;

import com.example.tp.domain.model.Book;
import com.example.tp.domain.model.Library;
import com.example.tp.domain.model.person.Person;

public class RenderBook {

    private final Person person;

    public RenderBook(Person person) {
        this.person = person;
    }

    public void execute(Book book) {
        if (book != null && book.isCorrect() && person.isAbleToBorrowBook()) {
            Book bookExists = person.findBorrowedBook(book);
            if (bookExists != null) {
                person.renderBook(book);
            }
        }
    }
}
