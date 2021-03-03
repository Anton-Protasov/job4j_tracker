package ru.job4j.tracker;

import java.util.Scanner;

/*
 * 2.1. Реализация класса StartUI [#395219]
 * консольное приложение для работы с классом ru.job4j.tracker.Tracker
 * При запуске метода main в классе StartUI пользователю отображается следующее меню в консоли:
0. Add new Item / 1. Show all items / 2. Edit item / 3. Delete item / 4. Find item by Id / 5. Find items by name /
/ 6. Exit Program / Select:
 */

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;

        while (run) {
            this.showMenu();
            int input = Integer.parseInt(scanner.nextLine());

            if (input == 0) {
                System.out.print("Введите имя заявки: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
                System.out.println("Заявка успешно заведена");
                System.out.println();
            } else if (input == 1) {
                Item[] rsl;
                Item item = new Item();
                rsl = tracker.findAll();
                for (int i = 0; i < rsl.length; i++) {
                    System.out.println(rsl[i]);
                }
                System.out.println();
            } else if (input == 2) {
                System.out.print("Введите номер заявки, которую необходимо отредактировать: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите новое имя заявки " + id + ": ");
                String name = scanner.nextLine();
                Item newItem = new Item();
                newItem.setName(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Замена заявки произошла успешно");
                } else {
                    System.out.println("Заявки с указанным номером не существует");
                }
                System.out.println();
            } else if (input == 3) {
                System.out.print("Введите номер заявки, которую необходимо удалить: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Удаление заявки произошла успешно");
                } else {
                    System.out.println("Заявки с указанным номером не существует");
                }
                System.out.println();
            } else if (input == 4) {
                System.out.print("Введите номер заявки, которую необходимо найти: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println("Имя заявки с номером " + id + " : " + item.getName());
                } else {
                    System.out.println("Заявки с указанным номером не существует");
                }
                System.out.println();
            } else if (input == 5) {
                System.out.print("Введите имя заявки, которую необходимо найти: ");
                String name = scanner.nextLine();
                Item item = new Item();
                Item[] rsl;
                rsl = tracker.findByName(name);
                if (rsl.length > 0) {
                    for (int i = 0; i < rsl.length; i++) {
                        System.out.println(rsl[i]);
                    }
                } else {
                    System.out.println("Заявки с указанным именем не существуют");
                }
                System.out.println();
            } else if (input == 6) run = false;
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}