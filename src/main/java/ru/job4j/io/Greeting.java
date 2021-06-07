package ru.job4j.io;

import java.util.Scanner;

/*
1. Чтение из консоли. Класс Scanner. [#395207]
 */

public class Greeting {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Добро пожаловать. Как Вас зовут? ");
        String name = input.nextLine();
        System.out.println(name + ", рад Вас видеть!");
    }
}
