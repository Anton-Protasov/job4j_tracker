package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 2.1. Реализация класса StartUI [#395219]
 * консольное приложение для работы с классом ru.job4j.tracker.Tracker
 * При запуске метода main в классе StartUI пользователю отображается следующее меню в консоли:
0. Add new Item / 1. Show all items / 2. Edit item / 3. Delete item / 4. Find item by Id / 5. Find items by name /
/ 6. Exit Program / Select:
 */

public class StartUI {

/*
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Введите имя заявки: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Replace Item ====");
        int id = input.askInt("Введите номер заявки, " +
                "которую необходимо отредактировать: ");
        String name = input.askStr("Введите новое имя заявки " + id + ": ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Замена заявки произошла успешно");
        } else {
            System.out.println("Заявки с указанным номером не существует");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        int id = input.askInt("Введите номер заявки, которую необходимо удалить: ");
        if (tracker.delete(id)) {
            System.out.println("Удаление заявки произошла успешно");
        } else {
            System.out.println("Заявки с указанным номером не существует");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find Item By Id ====");
        int id = input.askInt("Введите номер заявки, которую необходимо найти: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Имя заявки с номером " + id + " : " + item.getName());
        } else {
            System.out.println("Заявки с указанным номером не существует");
        }
    }

    public static void findItemName(Input input, Tracker tracker) {
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
    }

        public void init(Input input, Tracker tracker) {
        boolean run = true;

        while (run) {
            this.showMenu();
            int vvod = input.askInt(" ");

            if (vvod == 0) {
                StartUI.createItem(input, tracker);
                System.out.println("Заявка успешно заведена");
                System.out.println();
            } else if (vvod == 1) {
                Item[] rsl = tracker.findAll();
                for (int i = 0; i < rsl.length; i++) {
                    System.out.println(rsl[i]);
                }
                System.out.println();
            } else if (vvod == 2) {
                StartUI.replaceItem(input, tracker);
                System.out.println();
            } else if (vvod == 3) {
                StartUI.deleteItem(input, tracker);
                System.out.println();
            } else if (vvod == 4) {
                StartUI.findItemById(input, tracker);
                System.out.println();
            } else if (vvod == 5) {
                StartUI.findItemName(input, tracker);
                System.out.println();
            } else if (vvod == 6) run = false;
        }
    }

*/

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

//public void init(Input input, Tracker tracker, UserAction[] actions) {
public void init(Input input, Tracker tracker, List<UserAction> actions) {
    boolean run = true;
    while (run) {
        this.showMenu(actions);
        int select = input.askInt("Select: ");
//        if (select < 0 || select >= actions.length) {
        if (select < 0 || select >= actions.size()) {
//            out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
            out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
            continue;
        }
//        UserAction action = actions[select];
        UserAction action = actions.get(select);
        run = action.execute(input, tracker);
    }
}

/*
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
*/
/*
    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
           out.println(index + ". " + actions[index].name());
        }
    }
 */

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.naturalOrder();
        tracker.reversOrder();
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
//        new StartUI().init(input, tracker);
        /*
        UserAction[] actions = {
                    new CreateAction(output),
                    new ShowAction(output),
                    new EditAction(output),
                    new DeleteAction(output),
                    new FindActionById(output),
                    new FindActionByName(output),
                    new ExitAction()
            };
         */
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new ShowAction(output),
                new EditAction(output),
                new DeleteAction(output),
                new FindActionById(output),
                new FindActionByName(output),
                new ExitAction()
        );
            new StartUI(output).init(input, tracker, actions);
    }
}
