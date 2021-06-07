package ru.job4j.poly;

public class Cow implements Animals {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук: Му-му.");
    }
}
