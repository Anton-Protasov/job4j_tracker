package ru.job4j.tracker;

import java.util.Arrays;

/*
 * 5. Tracker - хранилище [#395287]
 * Поле private Item[] items = new Item[100] содержит возможное количество заявлений
 * Метод public Item add(Item item) добавляет заявку, переданную в аргументах в массив заявок items
 * Метод public Item[] findAll() возвращает копию массива items без null элементов (без пустых ячеек)
 * Метод public Item[] findByName(String key) проверяет в цикле все элементы массива items, сравнивая name
 * (используя метод getName класса Item) с аргументом метода String key
 * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
 * Алгоритм этого метода аналогичен методу findAll
 * Метод public Item findById(int id) проверяет в цикле все элементы массива items, сравнивая id с аргументом int id
 * и возвращает найденный Item. Если Item не найден - возвращает null.
 *
 */

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int size2 = 0;
        Item[] rsl = new Item[items.length];
        for (int i = 0; i < size; i++) {
            String name = items[i].getName();
            if (name.equals(key)) {
                rsl[size2] = items[i];
                size2++;
            }
        }
        return Arrays.copyOf(rsl, size2);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}
