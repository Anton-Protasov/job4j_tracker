package ru.job4j.collection;

import java.util.Comparator;

/**
 * 1. Для модели ru.job4j.collection.Job компаратор:
 *  - по имени и по возрастанию
 */

public class JobSortByName implements Comparator<Job>  {
    @Override
    public int compare(Job ob1, Job ob2) {
        return ob1.getName().compareTo(ob2.getName());
    }
}
