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
        Item[] rsl;
        Item item = new Item();
        boolean run = true;

        while (run) {
            this.showMenu();

            int input = Integer.parseInt(scanner.nextLine());

            if (input == 0) {
                System.out.print("Введите имя заявки: ");
                String name = scanner.nextLine();
                item.setName(name);
                tracker.add(item);
                System.out.println("Заявка успешно заведена");
                System.out.println();
            }

            if (input == 1) {
                tracker.findAll();
                rsl = new Item[tracker.findAll().length];
                for (int i = 0; i < rsl.length; i++) {
                    System.out.println("Заявка № " + item.getId() + " имя заявки: " + item.getName());
                }
                System.out.println();
            }

            if (input == 2) {
                System.out.print("Введите номер заявки, которую необходимо отредактировать: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите имя заявки, которую необходимо отредактировать: ");
                String name = scanner.nextLine();
                Item newItem = new Item();
                newItem.setName(name);
                tracker.replace(id, newItem);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Замена заявки произошла успешно");
                } else {
                    System.out.println("Заявки с указанным номером не существует");
                }
                System.out.println();
            }

            if (input == 3) {
                System.out.print("Введите номер заявки, которую необходимо удалить: ");
                int id = Integer.parseInt(scanner.nextLine());
                tracker.delete(id);
                if (tracker.delete(id)) {
                    System.out.println("Удаление заявки произошла успешно");
                } else {
                    System.out.println("Заявки с указанным номером не существует");
                }
                System.out.println();
            }

            if (input == 4) {
                System.out.print("Введите номер заявки, которую необходимо найти: ");
                int id = Integer.parseInt(scanner.nextLine());
                item = tracker.findById(id);
                if (item != null) {
                    System.out.println("Имя заявки с номером " + id + " : " + item.getName());
                } else {
                    System.out.println("Заявки с указанным номером не существует");
                }
                System.out.println();
            }

            if (input == 5) {
                System.out.print("Введите имя заявки, которую необходимо найти: ");
                String name = scanner.nextLine();
                rsl = tracker.findByName(name);
                if (rsl.length > 0) {
                    for (int i = 0; i < rsl.length; i++) {
                        System.out.println("Заявка №" + item.getId() + "имя заявки: " + item.getName());
                    }
                } else {
                    System.out.println("Заявки с указанным именем не существуют");
                }
                System.out.println();
            }

            if (input == 6) run = false;
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