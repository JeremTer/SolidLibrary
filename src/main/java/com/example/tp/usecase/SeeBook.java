package com.example.tp.usecase;

import com.example.tp.domain.model.Book;
import com.example.tp.domain.model.Library;

public class SeeBook {

    private final Library library;

    public SeeBook(Library library) {
        this.library = library;
    }

    public void execute(Book book) {
        Book bookExists = library.findBook(book);
        if (bookExists != null) {
            library.showBook(book);
        }
    }

}
