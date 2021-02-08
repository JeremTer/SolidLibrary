package com.example.tp.model;

import java.util.Objects;

public class Book {

    private final String title;
    private final String authorName;
    private boolean available;

    public Book(String title, String authorName) {
        this.title = title;
        this.authorName = authorName;
        this.available = true;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public boolean isCorrect() {
        return this.title != null
                && !this.title.isBlank()
                && this.authorName != null
                && !this.authorName.isBlank();
    }

    public void borrow() {
        this.available = false;
    }

    public void render() {
        this.available = true;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
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
