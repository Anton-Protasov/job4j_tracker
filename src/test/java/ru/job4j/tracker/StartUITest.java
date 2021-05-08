package ru.job4j.tracker;

import java.util.Scanner;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class StartUITest {

/*
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);                  //Создаем объект input. input - массив с атрибутами заявки
        Tracker tracker = new Tracker();                       //Создаем объект tracker.
        StartUI.createItem(input, tracker);                    //Заводим заявку в tracker.
        Item created = tracker.findAll()[0];                   //Создаем переменную create, которой присваиваем результат поиска заявки с индексом [0]
        Item expected = new Item("Fix PC");              //Создаем заявку с ожидаемыми ответами.
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();                              //Создаем объект tracker.
        Item item = new Item("new item");                       //Создаем объект item
        tracker.add(item);                                            //Добавляем item в tracker. После этой операции у нас есть id.
        String[] answers = {                                          //Создаем массив замены:
                String.valueOf(item.getId()),                         //Получаем {"1", "replaced item"}
                "replaced item"                                       //answers[0] = "1"; answers[1] = "replaced item"
        };
        StartUI.replaceItem(new StubInput(answers), tracker);         //Вызываем тестируемый метод. Не понятно что здесь происходит ((
        Item replaced = tracker.findById(item.getId());               //Ищем по item.id замененный item в объекте tracker
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {

        Tracker tracker = new Tracker();
        Item item = new Item("Deleted item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue()));
    }
 */

    /**
     * Сценарий теста.
     * 1. Показать меню.
     * 2. Выбрать пункт "Создание заявки"
     * 3. Выбрать пункт "Выйти"
     * 4. Проверить, что в объект Tracker появилась новая заявка с именем "Item name".
     */

    /*
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"} // 0 - это пункт меню "Создать новую заявку"
                                                     // "Item name" - это будет имя новой заявки.
                                                     // 1 - это пункт меню "Выйти".
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }
     */

 /*
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        // Добавим в tracker новую заявку
        Item item = tracker.add(new Item("Replaced item"));
        // Входные данные должны содержать ID добавленной заявки item.getId()
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0",String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }
*/

    /*
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        // Добавим в tracker новую заявку
        Item item = tracker.add(new Item("Deleted item"));
        // Входные данные должны содержать ID добавленной заявки item.getId()
        Input in = new StubInput(
                new String[] {"0",String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
     */
/*
    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + " Program"+System.lineSeparator()
        ));
    }
 */
    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + " Program"+System.lineSeparator()
        ));
    }

    /*
    @Test
    public void whenShow() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("New item"));

        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Show all items" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator() +
                item + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Show all items" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator()));
    }
     */
    @Test
    public void whenShow() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("New item"));

        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = List.of(
                new ShowAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Show all items" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator() +
                item + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Show all items" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator()));
    }
/*
    @Test
    public void whenFindByNameAction() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("New item"));

        Input in = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        UserAction[] actions = {
                new FindActionByName(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Find items by name" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator() +
                "=== Find Item By Name ====" + System.lineSeparator() +
                item + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Find items by name" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator()));
    }
*/
    @Test
    public void whenFindByNameAction() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("New item"));

        Input in = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        List<UserAction> actions = List.of(
                new FindActionByName(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Find items by name" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator() +
                "=== Find Item By Name ====" + System.lineSeparator() +
                item + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Find items by name" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator()));
    }
/*
    @Test
    public void whenFindByIDAction() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("New item"));

        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindActionById(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Find item by Id" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator() +
                "=== Find Item By Id ====" + System.lineSeparator() +
                item + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Find item by Id" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator()));
    }
 */
    @Test
    public void whenFindByIDAction() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("New item"));

        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = List.of(
                new FindActionById(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Find item by Id" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator() +
                "=== Find Item By Id ====" + System.lineSeparator() +
                item + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Find item by Id" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator()));
    }
/*
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"100", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                )
        );
    }
 */
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"100", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                )
        );
    }
}
