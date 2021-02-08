package com.example.tp.usecase;

import com.example.tp.domain.model.Book;
import com.example.tp.domain.model.Library;
import com.example.tp.domain.service.BookGetter;
import com.example.tp.domain.service.BookSaver;
import com.example.tp.domain.model.person.Person;
import com.example.tp.domain.service.BookSelector;

public class RenderBook {

    private final Person person;
    private final Library library;
    private final BookSaver bookSaver;
    private final BookSelector bookSelector;
    private final BookGetter bookGetter;

    public RenderBook(Person person, Library library, BookSaver bookSaver, BookSelector bookSelector, BookGetter bookGetter) {
        this.library = library;
        this.bookSaver = bookSaver;
        this.person = person;
        this.bookSelector = bookSelector;
        this.bookGetter = bookGetter;
    }

    public void execute() {
        if (person.isAbleToBorrowBook()) {
            Book book = bookSelector.selectBook();
            loadBooks();

            if (person.findBorrowedBook(book) != null) {
                removeBookFromPersonBorrowedBooks(book);
                renderBookToTheLibrary(book);
            }
        }
    }

    private void renderBookToTheLibrary(Book book) {
        library.addBook(book);
        bookSaver.saveBooksInLibrary(library.getAllBooks());
    }

    public void removeBookFromPersonBorrowedBooks(Book book) {
        person.renderBook(book);
        bookSaver.savePersonBorrowedBooks(person, person.borrowedBooks());
    }

    public void loadBooks() {
        library.loadBooks(bookGetter.getLibraryBooks());
        person.loadBorrowedBooks(bookGetter.getPersonBorrowedBooks(person));
    }
}
