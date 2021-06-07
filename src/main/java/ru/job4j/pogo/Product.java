package ru.job4j.pogo;

import java.util.Objects;

/**
 * 3. Массивы и модели. [#395279]
 * 3.1. Массив с пустыми ячейками [#395281]
 * 4. Сравнение моделей. Метод equals [#395280]
 */

public class Product {
    private String name;
    private int count;

    public Product(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return count == product.count
                && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count);
    }
}
