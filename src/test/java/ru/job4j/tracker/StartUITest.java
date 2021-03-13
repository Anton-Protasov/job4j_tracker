package ru.job4j.tracker;

import java.util.Scanner;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {
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
        String[] answers = {
                String.valueOf(item.getId()),
                item.getName()
        };
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted.getName(), is(nullValue()));


        /*
        Tracker tracker = new Tracker();
        String[] answers = {"Deleted item"};
        Input input = new StubInput(answers);
        StartUI.createItem(input, tracker);
        StartUI.deleteItem(input, tracker);
        Item created = tracker.findAll()[0];
        assertThat(created.getName(), is(nullValue()));
         */
    }
}
