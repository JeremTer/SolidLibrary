package com.example.tp;

import com.example.tp.model.Book;
import com.example.tp.model.Library;
import com.example.tp.model.LibraryBooks;
import com.example.tp.model.Person;
import com.example.tp.model.status.StatusGuest;
import com.example.tp.model.status.StatusLibrarian;
import com.example.tp.model.status.StatusMember;

public class Main {

    public static void main(String[] args) {
        Library library = new Library(new LibraryBooks());
        Person librarian = new Person(new StatusLibrarian(), library);
        Person member = new Person(new StatusMember(), library);
        Person guest = new Person(new StatusGuest(), library);
        //guest add book
        guest.addBook(new Book("Les 30", "Moi"));
        library.showAllBooks();//should see nothing

        //member add book
        member.addBook(new Book("Les 30", "Moi"));
        library.showAllBooks();//should see nothing

        //librarian add book
        librarian.addBook(new Book("Les 30", "Moi"));
        library.showAllBooks();//should see book added

        //see all book
        guest.seeAllLibraryBooks();
        member.seeAllLibraryBooks();
        librarian.seeAllLibraryBooks();

        guest.seeBook(new Book("Les 30", "Moi"));
//        guest.seeBook(new Book("", ""));
//        guest.addBook();
//        member.borrowBook(new Book("", ""));
//        librarian.addBook(new Book("Les 30", "Moi"));
//
//        member.seeBorrowedBooks();
//        librarian.seeAllLibraryBooks();
    }
}
