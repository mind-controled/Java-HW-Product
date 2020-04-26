package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    @Test
    void shouldSearchByAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(2, 200, "Requiem For A Dream", "Hubert Selby Jr.")};
        Product[] actual = manager.searchBy("Hubert Selby Jr.");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(3, 300, "Fear & Loathing In Las Vegas", "Hunter Stockton Thompson")};
        Product[] actual = manager.searchBy("Fear & Loathing In Las Vegas");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByPhoneName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(6, 3000, "iPhone 11", "Apple")};
        Product[] actual = manager.searchBy("iPhone 11");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(4, 1000, "Galaxy S10", "Samsung")};
        Product[] actual = manager.searchBy("samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchByAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {};
        Product[] actual = manager.searchBy("Виктор Пелевин");
        assertArrayEquals(expected, actual);
    }
}