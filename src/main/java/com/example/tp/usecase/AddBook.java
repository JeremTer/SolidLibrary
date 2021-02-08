package com.example.tp.usecase;

import com.example.tp.domain.model.Book;
import com.example.tp.domain.model.Library;
import com.example.tp.domain.model.person.Person;

public class AddBook {

    private final Library library;
    private final Person person;

    public AddBook(Library library, Person person) {
        this.person = person;
        this.library = library;
    }

    public void execute(Book book) {
        if (book != null && book.isCorrect() && person.isAbleToAddNewBook()) {
            if (library.findBook(book) == null) {
                library.addBook(book);
            }
        }
    }
}
