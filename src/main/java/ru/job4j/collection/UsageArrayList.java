package ru.job4j.collection;

import java.util.ArrayList;

/**
 * 0. Коллекции, ArrayList, List, Обобщения [#395192]
 */
public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add("Petr");
        name.add("Ivan");
        name.add("Stepan");
        for (String value: name) {
            System.out.println(value);
        }
    }
}
