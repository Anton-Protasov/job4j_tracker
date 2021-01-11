package ru.job4j.oop;
/*
1.3. Вызов метода с аргументами. [#395261]
 */

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else {
            if (position == 2) {
                System.out.println("Спокойной ночи");
            } else {
                System.out.println("Песня не найдена");
            }
        }
    }

    public static void main(String[] args) {
        Jukebox select = new Jukebox();
        select.music(1);
        select.music(2);
        select.music(3);
    }
}
