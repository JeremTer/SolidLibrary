package com.example.tp;


import com.example.tp.domain.model.*;
import com.example.tp.domain.model.person.Person;
import com.example.tp.domain.model.person.ability.GuestAbilities;
import com.example.tp.domain.model.person.ability.LibrarianAbilities;
import com.example.tp.domain.model.person.ability.MemberAbilities;
import com.example.tp.domain.service.*;
import com.example.tp.usecase.*;

import java.util.Scanner;

public class Main {
    static final Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        final Library library = new Library(new LibraryBooks());
        var action = 0;

        Person person = choosePerson();
        if (person == null) return;

        BookSaver bookSaver = new BookSaverFile();
        BookGetter bookGetter = new BookGetterFile();
        BookSelector bookSelector = new BookSelectorInput();


        while (action != 7) {
            action = getAction();

            if (action == 1) {
                AddBook addBook = new AddBook(library, person, bookSaver, bookSelector, bookGetter);
                addBook.execute();
            }
            if (action == 2) {
                SeeLibraryBook seeLibraryBook = new SeeLibraryBook(library, bookGetter, bookSelector);
                seeLibraryBook.execute();
            }
            if (action == 3) {
                SeeAllLibraryBooks seeAllLibraryBooks = new SeeAllLibraryBooks(library, bookGetter);
                seeAllLibraryBooks.execute();
            }
            if (action == 4) {
                SeeBorrowedBooks seeBorrowedBooks = new SeeBorrowedBooks(bookGetter, person);
                seeBorrowedBooks.execute();
            }
            if (action == 5) {
                BorrowBook borrowBook = new BorrowBook(library, person, bookSaver, bookSelector, bookGetter);
                borrowBook.execute();
            }
            if (action == 6) {
                RenderBook renderBook = new RenderBook(person, library, bookSaver, bookSelector, bookGetter);
                renderBook.execute();
            }
        }
    }

    private static int getAction() {
        System.out.println("Enter the number of the action you want to do");
        System.out.println("1 : Add a book");
        System.out.println("2 : See a book");
        System.out.println("3 : See all books");
        System.out.println("4 : See my borrowed books");
        System.out.println("5 : Borrow a book");
        System.out.println("6 : Render a book");
        System.out.println("7 : Quit");
        var action = console.nextInt();
        console.nextLine();
        return action;
    }

    private static Person choosePerson() {
        System.out.println("Welcome ! Who are you ?");
        System.out.println("1 : The librarian");
        System.out.println("2 : The member");
        System.out.println("3 : The guest");
        var personNumber = console.nextInt();
        console.nextLine();
        if (personNumber == 1) return new Person(new LibrarianAbilities(), "Librarian");
        if (personNumber == 2) return new Person(new MemberAbilities(), "Member");
        if (personNumber == 3) return new Person(new GuestAbilities(), "Guest");
        return null;
    }
}
