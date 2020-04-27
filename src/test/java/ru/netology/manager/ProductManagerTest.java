package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Product item1 = new Book(1, 100, "Fight Club", "Chuck Palahniuk");
    private Product item2 = new Book(2, 200, "Requiem For A Dream", "Hubert Selby Jr.");
    private Product item3 = new Book(3, 300, "Fear & Loathing In Las Vegas", "Hunter Stockton Thompson");
    private Product item4 = new Smartphone(4, 1000, "Galaxy S10", "Samsung");
    private Product item5 = new Smartphone(5, 2000, "Mi Note 10", "Xiaomi");
    private Product item6 = new Smartphone(6, 3000, "iPhone 11", "Apple");

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
    void shouldSearchByAuthor() {
        Product[] expected = new Product[]{item2};
        Product[] actual = manager.searchBy("Hubert Selby Jr.");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        Product[] expected = new Product[]{item3};
        Product[] actual = manager.searchBy("Fear & Loathing In Las Vegas");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByPhoneName() {
        Product[] expected = new Product[]{item6};
        Product[] actual = manager.searchBy("iPhone 11");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {
        Product[] expected = new Product[]{item4};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthorNegative() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Виктор Пелевин");
        assertArrayEquals(expected, actual);
    }
}