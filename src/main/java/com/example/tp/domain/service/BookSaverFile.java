package com.example.tp.domain.service;

import com.example.tp.domain.model.LibraryBooks;
import com.example.tp.domain.model.person.Person;

import java.io.FileWriter;
import java.io.IOException;

public class BookSaverFile implements BookSaver {

    private final String LIBRARY_FILENAME = "Library.txt";

    @Override
    public void saveBooksInLibrary(LibraryBooks books) {
        try {
            FileWriter myWriter = new FileWriter(LIBRARY_FILENAME);
            myWriter.write(books.toString());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void savePersonBorrowedBooks(Person person, LibraryBooks books) {
        try {
            FileWriter myWriter = new FileWriter(person.getName() + ".txt");
            myWriter.write(books.toString());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
