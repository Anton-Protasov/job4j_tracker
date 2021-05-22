package ru.job4j.collection;

import java.util.Comparator;

/**
 * 0. Сортировка [example]
 * Реализует интерфейс java.util.Comparator
 * Теперь можно добавить сортировку по имени по возрастанию (Natural Order) через компаратор.
 */

public class SortByNameJobNO implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return first.getName().compareTo(second.getName());
    }
}
