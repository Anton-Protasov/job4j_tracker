package ru.job4j.search;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * 1. Телефонный справочник на базе ArrayList [#395186]
 */

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедщих пользователей.
     * String name, String surname, String phone, String address
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        /*
        for (Person value: persons) {
            if (value.getName().equals(key) || value.getSurname().equals(key)
                    || value.getPhone().equals(key) || value.getAddress().equals(key)) {
                result.add(value);
            }
        }
         */

        /*
        Применим функциональный интерфейс java.util.function.Predicate и метод or.
         */
        Predicate<Person> combine = (value) -> value.getName().equals(key)
                || value.getSurname().equals(key)
                || value.getPhone().equals(key) || value.getAddress().equals(key);
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
                }
            }

        return result;
    }
}
