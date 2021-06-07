package ru.job4j.search;

/**
 * 2. Очередь с приоритетом на LinkedList [#395187]
 */

import java.util.LinkedList;

/**
 * Класс описывает работу простейшей очереди по приоритету, которая работает
 * по принципу FIFO (first in - first out)
 * @author STAS KOROBEYNIKOV
 * @version 1.0
 */
public class PriorityQueue {
    /**
     * Хранение задания осуществляется в коллекции типа LinkedList
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод принимает на вход заявку и добавляет ее в очередь.
     * Если встречаются 2 задания с одинаковым приоритетом, то в очереди
     * они распределяются по принципу FIFO.
     * @param task задача которая добавляется в очередь
     */
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (element.getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    /**
     * Метод позволяет получить первую задачу в очереди
     * @return возвращает задачу из головы очереди или null если очередь пуста
     */
    public Task take() {
        return tasks.poll();
    }

    public static void main(String[] args) {
        PriorityQueue ex = new PriorityQueue();
        ex.put(new Task("A", 3));
        ex.put(new Task("B", 1));
        ex.put(new Task("C", 10));
        for (Task el: ex.tasks) {
            System.out.println(el);
        }
    }
}
