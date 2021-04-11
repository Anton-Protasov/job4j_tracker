package ru.job4j.tracker;

/**
 *  класс SingleTracker должен реализовывать шаблон singleton
 */

public final class SingleTracker {
    private Tracker tracker = new Tracker();
    private static SingleTracker example;

    private SingleTracker(){
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key){
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item){
        return tracker.replace(id, item);
    }

    public boolean delete(int id){
        return tracker.delete(id);
    }

    public static SingleTracker getExample() {
        return example = new SingleTracker();
    }
}

