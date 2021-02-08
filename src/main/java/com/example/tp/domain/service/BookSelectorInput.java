package com.example.tp.domain.service;

import com.example.tp.domain.model.Book;

import java.util.Scanner;

public class BookSelectorInput implements BookSelector {
    final Scanner scanner;

    public BookSelectorInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Book selectBook() {
        System.out.println("Enter the title : ");
        var title = scanner.nextLine();
        System.out.println("Enter the author's name : ");
        var authorName = scanner.nextLine();
        return new Book(title, authorName);
    }
}
