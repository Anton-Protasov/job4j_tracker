package ru.job4j.tracker;

/*
 * 2.1. Реализация класса StartUI [#395219]
 * консольное приложение для работы с классом ru.job4j.tracker.Tracker
 * При запуске метода main в классе StartUI пользователю отображается следующее меню в консоли:
0. Add new Item / 1. Show all items / 2. Edit item / 3. Delete item / 4. Find item by Id / 5. Find items by name /
/ 6. Exit Program / Select:
 */

import ru.job4j.oop.Transport;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;

        while (run) {
            this.showMenu();
            int vvod = Integer.parseInt(input.askStr(" "));

            if (vvod == 0) {
                String name = input.askStr("Введите имя заявки: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Заявка успешно заведена");
                System.out.println();
            } else if (vvod == 1) {
                Item[] rsl = tracker.findAll();
                for (int i = 0; i < rsl.length; i++) {
                    System.out.println(rsl[i]);
                }
                System.out.println();
            } else if (vvod == 2) {
                int id = input.askInt("Введите номер заявки, " +
                        "которую необходимо отредактировать: ");
                String name = input.askStr("Введите новое имя заявки " + id + ": ");
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Замена заявки произошла успешно");
                } else {
                    System.out.println("Заявки с указанным номером не существует");
                }
                System.out.println();
            } else if (vvod == 3) {
                int id = input.askInt("Введите номер заявки, которую необходимо удалить: ");
                if (tracker.delete(id)) {
                    System.out.println("Удаление заявки произошла успешно");
                } else {
                    System.out.println("Заявки с указанным номером не существует");
                }
                System.out.println();
            } else if (vvod == 4) {
                int id = input.askInt("Введите номер заявки, которую необходимо найти: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println("Имя заявки с номером " + id + " : " + item.getName());
                } else {
                    System.out.println("Заявки с указанным номером не существует");
                }
                System.out.println();
            } else if (vvod == 5) {
                String name = input.askStr("Введите имя заявки, которую необходимо найти: ");
                Item[] rsl = tracker.findByName(name);
                if (rsl.length > 0) {
                    for (int i = 0; i < rsl.length; i++) {
                        System.out.println(rsl[i]);
                    }
                } else {
                    System.out.println("Заявки с указанным именем не существуют");
                }
                System.out.println();
            } else if (vvod == 6) run = false;
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println();
        System.out.print("Выберите пункт меню: ");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}