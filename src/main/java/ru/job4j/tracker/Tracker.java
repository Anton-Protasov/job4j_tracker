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
 * 6. Метод замены заявки. Tracker.replace [#395282]
 * Процесс замены отличается от процесса добавление, тем что у нас остается одинаковый ключ id.
 * В случае добавление новой заявки, мы генерируем всегда новый ключ. Поэтому
 * Первоначально нам нужно найти ячейку с id приходящем в параметре  - метод indexOf(int id)
 * метод public boolean replace(int id, Item item) заменяет заявки c id на заявку item, При замене старый id сохраняем.
 * Вернуть true, если замена произведена или false, если index по id не найден
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
        /* Данная часть программы из задачи 5 при реализации задачи 6 преобразована
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
         */
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = false;
        if (index != -1) {
            item.setId(items[index].getId());
            items[index] = item;
            rsl = true;
        }
        return rsl;
    }
}
