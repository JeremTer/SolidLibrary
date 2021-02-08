package com.example.tp;


import com.example.tp.domain.model.Book;
import com.example.tp.domain.model.Library;
import com.example.tp.domain.model.LibraryBooks;
import com.example.tp.domain.model.person.Person;
import com.example.tp.domain.model.person.ability.GuestAbilities;
import com.example.tp.domain.model.person.ability.LibrarianAbilities;
import com.example.tp.domain.model.person.ability.MemberAbilities;
import com.example.tp.usecase.*;

import java.util.Scanner;

public class Main {
    static final Scanner console = new Scanner(System.in);
    static final Library library = new Library(new LibraryBooks());

    public static void main(String[] args) {
        var action = 0;
        Person person = choosePerson();

        while (action != 6) {
            action = getAction();

            if (action == 1) {
                AddBook addBook = new AddBook(library, person);
                addBook.execute(enterBook());
            }
            if (action == 2) {
                SeeBook seeBook = new SeeBook(library);
                seeBook.execute(enterBook());
            }
            if (action == 3) {
                SeeAllBooks seeAllBooks = new SeeAllBooks(library);
                seeAllBooks.execute();
            }
            if (action == 4) {
                BorrowBook borrowBook = new BorrowBook(library, person);
                borrowBook.execute(enterBook());
            }
            if (action == 5) {
                RenderBook renderBook = new RenderBook(person);
                renderBook.execute(enterBook());
            }
        }
    }

    private static int getAction() {
        System.out.println("Enter the number of the action you want to do");
        System.out.println("1 : Add a book");
        System.out.println("2 : See a book");
        System.out.println("3 : See all books");
        System.out.println("4 : Borrow a book");
        System.out.println("5 : Render a book");
        System.out.println("6 : Quit");
        var action = console.nextInt();
        console.nextLine();
        return action;
    }

    private static Book enterBook() {
        System.out.println("Enter the title : ");
        var title = console.nextLine();
        System.out.println("Enter the author's name : ");
        var authorName = console.nextLine();
        return new Book(title, authorName);
    }

    private static Person choosePerson() {
        System.out.println("Welcome ! Who are you ?");
        System.out.println("1 : The librarian");
        System.out.println("2 : A member");
        System.out.println("3 : A guest");
        var personNumber = console.nextInt();
        console.nextLine();
        if (personNumber == 1) return new Person(new LibrarianAbilities());
        if (personNumber == 2) return new Person(new MemberAbilities());
        if (personNumber == 3) return new Person(new GuestAbilities());
        return null;
    }
}
