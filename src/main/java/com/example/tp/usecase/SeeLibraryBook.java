package com.example.tp.usecase;

import com.example.tp.domain.model.Book;
import com.example.tp.domain.model.Library;
import com.example.tp.domain.service.BookGetter;
import com.example.tp.domain.service.BookSelector;

public class SeeLibraryBook {

    private final Library library;
    private final BookGetter bookGetter;
    private final BookSelector bookSelector;

    public SeeLibraryBook(Library library, BookGetter bookGetter, BookSelector bookSelector) {
        this.library = library;
        this.bookGetter = bookGetter;
        this.bookSelector = bookSelector;
    }

    public void execute() {
        library.loadBooks(bookGetter.getLibraryBooks());
        Book book = bookSelector.selectBook();
        if (library.findBook(book) != null) {
            library.showBook(book);
        }
    }

}
