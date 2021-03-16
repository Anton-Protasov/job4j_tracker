package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name(){
        return "Delete item";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        int id = input.askInt("Введите номер заявки, которую необходимо удалить: ");
        if (tracker.delete(id)) {
            System.out.println("Удаление заявки произошла успешно");
        } else {
            System.out.println("Заявки с указанным номером не существует");
        }
        return true;
    }
}
