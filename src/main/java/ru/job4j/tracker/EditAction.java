package ru.job4j.tracker;

public class EditAction implements UserAction {

    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Replace Item ====");
        int id = input.askInt("Введите номер заявки, "
                + "которую необходимо отредактировать: ");
        String name = input.askStr("Введите новое имя заявки " + id + ": ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            out.println("Замена заявки произошла успешно");
        } else {
            out.println("Заявки с указанным номером не существует");
        }
        return true;
    }
}
