package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product itemToAdd = new Book(999, 999, "Trainspotting", "Irvine Welsh");

    @Test
    void shouldSave() {
        repository.save(itemToAdd);
        Product[] actual = repository.findAll();
        Product[] expected = {
                new Book(1, 100, "Fight Club", "Chuck Palahniuk"),
                new Book(2, 200, "Requiem For A Dream", "Hubert Selby Jr."),
                new Book(3, 300, "Fear & Loathing In Las Vegas", "Hunter Stockton Thompson"),
                new Smartphone(4, 1000, "Galaxy S10", "Samsung"),
                new Smartphone(5, 2000, "Mi Note 10", "Xiaomi"),
                new Smartphone(6, 3000, "iPhone 11", "Apple"),
                new Book(999, 999, "Trainspotting", "Irvine Welsh")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Product actual = repository.findById(1);
        Product expected = new Book(1, 100, "Fight Club", "Chuck Palahniuk");
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindById() {
        Product actual = repository.findById(11111);
        assertNull(actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {
                new Book(2, 200, "Requiem For A Dream", "Hubert Selby Jr."),
                new Book(3, 300, "Fear & Loathing In Las Vegas", "Hunter Stockton Thompson"),
                new Smartphone(4, 1000, "Galaxy S10", "Samsung"),
                new Smartphone(5, 2000, "Mi Note 10", "Xiaomi"),
                new Smartphone(6, 3000, "iPhone 11", "Apple")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotRemoveById() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeById(11111));
    }
}