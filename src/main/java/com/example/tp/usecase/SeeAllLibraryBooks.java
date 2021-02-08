package com.example.tp.usecase;

import com.example.tp.domain.model.Library;
import com.example.tp.domain.service.BookGetter;

public class SeeAllLibraryBooks {

    private final Library library;
    private final BookGetter bookGetter;

    public SeeAllLibraryBooks(Library library, BookGetter bookGetter) {
        this.library = library;
        this.bookGetter = bookGetter;
    }

    public void execute() {
        library.loadBooks(bookGetter.getLibraryBooks());
        library.showAllBooks();
    }
}
