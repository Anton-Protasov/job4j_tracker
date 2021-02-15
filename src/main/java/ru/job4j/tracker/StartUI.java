package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * 5. Tracker - хранилище [#395287]
 *     Внутри метода main создайте объект Tracker. Вызовите у него метод add с объектом Item.
 *     Вызовите метод findById и найденный Item выведите на консоль.
 */

class StartUI {

    public static void main(String[] args) {

/*
        Item item = new Item(LocalDateTime.now());
        System.out.println("before formatting: " + item.created);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = item.created.format(formatter);
        System.out.println("after formatting:  " + currentDateTimeFormat);
 */

        Tracker tracker = new Tracker();
        Item item1 = new Item();
        Item item2 = new Item();
        item1.setName("Anton");
        tracker.add(item1);
        System.out.println("Элемент с ID = 1: "+ tracker.findById(1).getName());
        tracker.add(item2);
        System.out.println("Элемент с ID = 0: "+ tracker.findById(0));
    }
}
