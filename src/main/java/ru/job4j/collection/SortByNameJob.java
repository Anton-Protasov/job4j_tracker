package ru.job4j.collection;

import java.util.Comparator;

/**
 * 0. Сортировка [example]
 * Реализует интерфейс java.util.Comparator
 * Теперь можно добавить сортировку по имени через компаратор.
 */

public class SortByNameJob implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return first.getName().compareTo(second.getName());
    }
}
