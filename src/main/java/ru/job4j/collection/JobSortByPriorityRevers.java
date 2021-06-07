package ru.job4j.collection;

import java.util.Comparator;

/**
 * 1. Для модели ru.job4j.collection.Job компаратор:
 *    - по приоритету и по убыванию
 */

public class JobSortByPriorityRevers implements Comparator<Job> {
    @Override
    public int compare(Job ob1, Job ob2) {
        return Integer.compare(ob2.getPriority(), ob1.getPriority());
    }
}
