package com.example.tp.usecase;

import com.example.tp.domain.model.Book;
import com.example.tp.domain.service.BookGetter;
import com.example.tp.domain.service.BookSaver;
import com.example.tp.domain.model.Library;
import com.example.tp.domain.model.person.Person;
import com.example.tp.domain.service.BookSelector;

public class AddBook {

    private final Library library;
    private final Person person;
    private final BookSaver bookSaver;
    private final BookSelector bookSelector;
    private final BookGetter bookGetter;

    public AddBook(Library library, Person person, BookSaver bookSaver, BookSelector bookSelector, BookGetter bookGetter) {
        this.person = person;
        this.library = library;
        this.bookSaver = bookSaver;
        this.bookSelector = bookSelector;
        this.bookGetter = bookGetter;
    }

    public void execute() {
        if (person.isAbleToAddNewBook()) {

            library.loadBooks(bookGetter.getLibraryBooks());
            Book book = bookSelector.selectBook();

            if (book.isCorrect() && library.findBook(book) == null) {
                addBookToTheLibrary(book);
            }
        }
    }

    public void addBookToTheLibrary(Book book) {
        library.addBook(book);
        bookSaver.saveBooksInLibrary(library.getAllBooks());
    }
}
