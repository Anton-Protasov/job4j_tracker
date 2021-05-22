package ru.job4j.collection;

import java.util.Comparator;

/**
 * 0. Сортировка [example]
 * Реализует интерфейс java.util.Comparator
 * Теперь можно добавить сортировку по имени по убыванию (Reverse Order) через компаратор.
 */

public class SortByNameJobRO implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return second.getName().compareTo(first.getName());
    }
}
