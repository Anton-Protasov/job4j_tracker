package ru.job4j.tracker;

import java.util.Comparator;

/**
 * 0. Сортировка [#10096]
 * Создание для модели данных ru.job4j.tracker.Item компаратора, который сортирует данные по возрастанию.
 */

public class NaturalOrderItems implements Comparator <Item> {

    @Override
    public int compare(Item first, Item second) {
        return Integer.compare(first.getId(), second.getId());
    }
}

