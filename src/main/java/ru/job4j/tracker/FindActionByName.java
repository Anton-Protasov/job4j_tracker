package ru.job4j.tracker;

public class FindActionByName implements UserAction{
    @Override
    public String name() {
        return "Find items by name";
    }
    @Override
    public boolean execute(Input input, Tracker tracker){
        System.out.println("=== Find Item By Name ====");
        String name = input.askStr("Введите имя заявки, которую необходимо найти: ");
        Item[] rsl = tracker.findByName(name);
        if (rsl.length > 0) {
            for (int i = 0; i < rsl.length; i++) {
                System.out.println(rsl[i]);
            }
        } else {
            System.out.println("Заявки с указанным именем не существуют");
        }
        return true;
    }
}
