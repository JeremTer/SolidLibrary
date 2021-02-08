package com.example.tp.domain.service;

import com.example.tp.domain.model.Book;
import com.example.tp.domain.model.LibraryBooks;
import com.example.tp.domain.model.person.Person;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookGetterFile implements BookGetter {

    private final String LIBRARY_FILENAME = "Library.txt";

    @Override
    public LibraryBooks getLibraryBooks() {
        String fileLines = getFileLines(LIBRARY_FILENAME);
        if (!fileLines.isBlank()) {
            return getBooksFromLines(fileLines);
        }
        return new LibraryBooks();
    }

    @Override
    public LibraryBooks getPersonBorrowedBooks(Person person) {
        String fileLines = getFileLines(person.getName() + ".txt");
        if (!fileLines.isBlank()) {
            return getBooksFromLines(fileLines);
        }
        return new LibraryBooks();
    }

    private String getFileLines(String filename) {
        try {
            File myObj = new File(filename);
            if (!myObj.exists()) return "";
            Scanner myReader = new Scanner(myObj);
            StringBuilder stringBuilder = new StringBuilder();
            while (myReader.hasNextLine()) {
                stringBuilder.append(myReader.nextLine()).append("\n");
            }
            myReader.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private LibraryBooks getBooksFromLines(String lines) {
        LibraryBooks libraryBooks = new LibraryBooks();
        Map<String, String> bookMap = new HashMap<>();
        for (String line : lines.split("\n")) {
            bookMap.put(line.split("=")[0], line.split("=")[1]);
            if (bookMap.get("author") != null && bookMap.get("title") != null) {
                libraryBooks.addBook(new Book(bookMap.get("title"), bookMap.get("author")));
                bookMap = new HashMap<>();
            }
        }
        return libraryBooks;
    }


}
