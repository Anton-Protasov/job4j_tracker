package ru.job4j.tracker;

/**
 * 7. Date. Отображение даты. [#395274]
 *
 * - Добавьте поле типа LocalDateTime, присвойте имя created.
 * Сразу проинициализируйте это поле текущей датой и временем, используйте статический метод now().
 * Добавьте геттер, чтобы получить доступ к созданному полю.
 * Добавьте класс StartUI, в нем создайте один объект Item.
 * На этом объекте вызовите геттер поля created,
 * выведите полученную дату в консоль в отформатированном варианте,
 * в качестве паттерна используйте следующую строку: "dd-MMMM-EEEE-yyyy HH:mm:ss"
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private int id;
    private String name;
    LocalDateTime created;

    public Item() {
    }

    public Item(int id){
        this.id = id;
    }

    public Item(String name){
        this.name = name;
    }

    public Item(LocalDateTime created){
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateAndTime() {
        return created;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class StartUI {

    public static void main(String[] args) {
        Item item = new Item(LocalDateTime.now());
        System.out.println("before formatting: " + item.created);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = item.created.format(formatter);
        System.out.println("after formatting:  " + currentDateTimeFormat);
    }
}
