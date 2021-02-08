package com.example.tp.domain.service;

import com.example.tp.domain.model.LibraryBooks;
import com.example.tp.domain.model.person.Person;

public interface BookGetter {
    LibraryBooks getLibraryBooks();

    LibraryBooks getPersonBorrowedBooks(Person person);
}
