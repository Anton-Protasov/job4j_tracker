package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 0. Сортировка [example]
 * Реализует сортировку по возрастанию по полю priority,
 * а так же сделать сортировку по имени по возрастанию.
 */

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1),
                new Job("Mechanic", 7),
                new Job("Electric", 0)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
        Collections.sort(jobs, new SortByNameJobNO());
        System.out.println(jobs);
        Collections.sort(jobs, new SortByNameJobRO());
        System.out.println(jobs);
    }
}

