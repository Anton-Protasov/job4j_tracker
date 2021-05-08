package ru.job4j.tracker;

import java.util.List;
import java.util.ArrayList;

public class ShowAction implements UserAction {

    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    /*
    public boolean execute(Input input, Tracker tracker) {
        Item[] rsl = tracker.findAll();
        for (int i = 0; i < rsl.length; i++) {
            out.println(rsl[i]);
        }
     */
    public boolean execute(Input input, Tracker tracker) {
        List<Item> rsl = tracker.findAll();
        for (Item item: rsl) {
            out.println(item);
        }
        return true;
    }
}
