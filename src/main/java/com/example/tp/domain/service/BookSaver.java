package com.example.tp.domain.service;

import com.example.tp.domain.model.LibraryBooks;
import com.example.tp.domain.model.person.Person;

public interface BookSaver {
    void saveBooksInLibrary(LibraryBooks books);

    void savePersonBorrowedBooks(Person person, LibraryBooks books);
}
