package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        Item[] rsl = tracker.findAll();
        for (int i = 0; i < rsl.length; i++) {
            out.println(rsl[i]);
        }
        return true;
    }
}
