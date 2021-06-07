package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Item ====");
        int id = input.askInt("Введите номер заявки, которую необходимо удалить: ");
        if (tracker.delete(id)) {
            out.println("Удаление заявки произошла успешно");
        } else {
            out.println("Заявки с указанным номером не существует");
        }
        return true;
    }
}
