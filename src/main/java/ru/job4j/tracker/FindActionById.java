package ru.job4j.tracker;

public class FindActionById implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find Item By Id ====");
        int id = input.askInt("Введите номер заявки, которую необходимо найти: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Имя заявки с номером " + id + " : " + item.getName());
        } else {
            System.out.println("Заявки с указанным номером не существует");
        }
        return true;
    }
}
