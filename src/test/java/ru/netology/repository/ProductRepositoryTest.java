package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product item1 = new Book(1, 100, "Fight Club", "Chuck Palahniuk");
    private Product item2 = new Book(2, 200, "Requiem For A Dream", "Hubert Selby Jr.");
    private Product item3 = new Book(3, 300, "Fear & Loathing In Las Vegas", "Hunter Stockton Thompson");
    private Product item4 = new Smartphone(4, 1000, "Galaxy S10", "Samsung");
    private Product item5 = new Smartphone(5, 2000, "Mi Note 10", "Xiaomi");
    private Product item6 = new Smartphone(6, 3000, "iPhone 11", "Apple");

    private Product itemToAdd = new Book(999, 999, "Trainspotting", "Irvine Welsh");

    @BeforeEach
    void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);
    }

    @Test
    void shouldSave() {
        repository.save(itemToAdd);
        Product[] actual = repository.findAll();
        Product[] expected = {
                item1,
                item2,
                item3,
                item4,
                item5,
                item6,
                itemToAdd
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Product actual = repository.findById(1);
        Product expected = item1;
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
                item2,
                item3,
                item4,
                item5,
                item6
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotRemoveById() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeById(11111));
    }
}