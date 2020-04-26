package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepository {
    Product[] items = {new Book(1, 100, "Fight Club", "Chuck Palahniuk"),
            new Book(2, 200, "Requiem For A Dream", "Hubert Selby Jr."),
            new Book(3, 300, "Fear & Loathing In Las Vegas", "Hunter Stockton Thompson"),
            new Smartphone(4, 1000, "Galaxy S10", "Samsung"),
            new Smartphone(5, 2000, "Mi Note 10", "Xiaomi"),
            new Smartphone(6, 3000, "iPhone 11", "Apple")
    };

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}