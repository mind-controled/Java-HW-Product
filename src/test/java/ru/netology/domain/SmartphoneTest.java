package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SmartphoneTest {

    @Test
    void shouldMatchByManufacturer() {
        Smartphone smart = new Smartphone(4, 1000, "Galaxy S10", "Samsung");
        boolean actual = smart.matches("Samsung");
        assertTrue(actual);

    }

    @Test
    void shouldMatchByName() {
        Smartphone smart = new Smartphone(5, 2000, "Mi Note 10", "Xiaomi");
        boolean actual = smart.matches("Xiaomi");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByManufacturer() {
        Smartphone smart = new Smartphone(4, 1000, "Galaxy S10", "Samsung");
        boolean actual = smart.matches("Apple");
        assertFalse(actual);
    }

    @Test
    void shouldNotMatchByName() {
        Smartphone smart = new Smartphone(5, 2000, "Mi Note 10", "Xiaomi");
        boolean actual = smart.matches("iphone 11");
        assertFalse(actual);
    }
}