package ru.job4j.poly;

public class Goose implements Animals {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " произносит звук: Га-га");
    }
}
