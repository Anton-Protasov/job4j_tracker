package ru.job4j.search;

/**
 * 2. Очередь с приоритетом на LinkedList [#395187]
 */

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставить элемент в порядке приоритетности.
     * элимент с большим приоритетом идет вправо.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * В методе put вам нужно найти index нужного элемента.
     * Давайте рассмотрим ситуацию, когда элементов нет. В этом случае index будет равен 0.
     * Другой случай, когда вам нужно вставить элемент в конец списка.
     * В этом случае вы пройдете по всем элементам, и индекс будет равен размеру всей коллекции.
     */
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            while (task.getPriority() > element.getPriority()) {
                index++;
                break;
            }
        }
        this.tasks.add(index, task);
    }

    /**
     * Метод take возвращает первый элемент из списка и удаляет его.
     * Эти действия мы делаем через метод poll().
     */
    public Task take() {
        return tasks.poll();
    }

    public static void main(String[] args) {
        PriorityQueue ex = new PriorityQueue();
        ex.put(new Task("A", 3));
        ex.put(new Task("B", 1));
        ex.put(new Task("C", 10));
        for(Task el: ex.tasks)
        System.out.println(el);
    }
}
