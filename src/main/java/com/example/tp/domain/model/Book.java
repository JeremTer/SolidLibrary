package com.example.tp.domain.model;

import java.util.Objects;

public class Book {

    private final String title;
    private final String authorName;

    public Book(String title, String authorName) {
        this.title = title;
        this.authorName = authorName;
    }

    public boolean isCorrect() {
        return this.title != null
                && !this.title.isBlank()
                && this.authorName != null
                && !this.authorName.isBlank();
    }

    @Override
    public String toString() {
        return "title=" + title + "\nauthor=" + authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) && authorName.equals(book.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorName);
    }
}
