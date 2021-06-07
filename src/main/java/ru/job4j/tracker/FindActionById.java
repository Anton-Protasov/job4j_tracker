package ru.job4j.tracker;

public class FindActionById implements UserAction {

    private final Output out;

    public FindActionById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Item By Id ====");
        int id = input.askInt("Введите номер заявки, которую необходимо найти: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявки с указанным номером не существует");
        }
        return true;
    }
}
