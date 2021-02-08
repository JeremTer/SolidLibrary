package com.example.tp.usecase;

import com.example.tp.domain.model.Library;

public class SeeAllBooks {

    private final Library library;

    public SeeAllBooks(Library library) {
        this.library = library;
    }

    public void execute() {
        library.showAllBooks();
    }
}
