package com.example.tp.usecase;

import com.example.tp.domain.model.Book;
import com.example.tp.domain.service.BookGetter;
import com.example.tp.domain.service.BookSaver;
import com.example.tp.domain.model.Library;
import com.example.tp.domain.model.person.Person;
import com.example.tp.domain.service.BookSelector;

public class BorrowBook {

    private final Library library;
    private final Person person;
    private final BookSaver bookSaver;
    private final BookSelector bookSelector;
    private final BookGetter bookGetter;

    public BorrowBook(Library library, Person person, BookSaver bookSaver, BookSelector bookSelector, BookGetter bookGetter) {
        this.person = person;
        this.library = library;
        this.bookSaver = bookSaver;
        this.bookSelector = bookSelector;
        this.bookGetter = bookGetter;
    }

    public void execute() {
        if (person.isAbleToBorrowBook()
                && (person.borrowBookNumberLimitAtTheSameTime() > person.borrowedBooksNumber()
                || person.borrowBookNumberLimitAtTheSameTime() == -1)) {

            Book book = bookSelector.selectBook();
            loadBooks();

            if (book.isCorrect() && library.findBook(book) != null) {
                removeBookFromLibrary(book);
                addBorrowedBookToThePerson(book);
            }
        }
    }

    private void addBorrowedBookToThePerson(Book book) {
        person.borrowBook(book);
        bookSaver.savePersonBorrowedBooks(person, person.borrowedBooks());
    }

    private void removeBookFromLibrary(Book book) {
        library.removeBook(book);
        bookSaver.saveBooksInLibrary(library.getAllBooks());
    }

    private void loadBooks() {
        person.loadBorrowedBooks(bookGetter.getPersonBorrowedBooks(person));
        library.loadBooks(bookGetter.getLibraryBooks());
    }

}
