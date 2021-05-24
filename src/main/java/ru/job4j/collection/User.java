package ru.job4j.collection;

import java.util.Objects;

/**
 * 1. Организовать сортировку User [#10034]
 * В модели должны быть поля: имя и возраст.
 * Предусмотреть ситуацию, когда два пользователя имеют одинаковое имя.
 * В этом случае нужно сравнить их возраст.
 */

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        int rslAge = this.age;
        int rslName = this.name.compareTo(o.name);
        if (rslName == 0) {
            rslAge = Integer.compare(this.age, o.age);
        }
        return rslAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}