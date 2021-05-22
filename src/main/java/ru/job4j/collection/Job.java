package ru.job4j.collection;

/**
 * 0. Сортировка [example]
 * модель данных Job
 */

public class Job implements Comparable<Job> {
    private String name;
    private int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Job another) {
        return Integer.compare(priority, another.priority);
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}