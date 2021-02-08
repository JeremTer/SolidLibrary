package com.example.tp.usecase;


import com.example.tp.domain.model.Book;
import com.example.tp.domain.model.Library;
import com.example.tp.domain.model.person.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


class AddBookTest {

    AddBook addBook;

    @Mock
    Library mockedLibrary;

    @Mock
    Person mockedPerson;

    @BeforeEach
    public void setup() {
        addBook = new AddBook(mockedLibrary, mockedPerson);
    }

    @Test
    public void shouldAddBookInLibraryIfThePersonIsAbleTo() {

    }

    @Test
    public void shouldNotAddBookInLibraryIfThePersonIsNotAbleTo() {

    }

    @Test
    public void shouldNotAddBookInLibraryIfTheAuthorOrTheTitleIsIncorrect() {

    }


}
