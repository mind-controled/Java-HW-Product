package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldMatchByAuthor() {
        Book book = new Book(100, 100,"My Book", "Me");
        boolean actual = book.matches("Me");
        assertTrue(actual);

    }

    @Test
    void shouldMatchByName() {
        Book book = new Book(300, 300,"My Book2", "Me");
        boolean actual = book.matches("My Book2");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByAuthor() {
        Book book = new Book(100, 100,"My Book", "Me");
        boolean actual = book.matches("You");
        assertFalse(actual);

    }

    @Test
    void shouldNotMatchByName() {
        Book book = new Book(300, 300,"My Book2", "Me");
        boolean actual = book.matches("Your Book");
        assertFalse(actual);
    }
}