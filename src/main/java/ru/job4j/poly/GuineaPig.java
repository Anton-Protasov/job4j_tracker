package ru.job4j.poly;

public class GuineaPig implements Animals {
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " громко пищит для привлечения внимания.");
    }
}
