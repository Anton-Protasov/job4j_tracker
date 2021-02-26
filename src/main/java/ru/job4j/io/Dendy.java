package ru.job4j.io;

import java.util.Scanner;

/*
2. Scanner и чтение числа из консоли. [#395208]
В этом уроке мы познакомимся с подходом в создании примитивных программ за счет постоянного опроса пользователя.
Вначале мы показываем пользователю меню с пунктами игр.
Последним пунктом в меню будет "выход".
Если пользователь выбрал этот пункт, то нужно выйти из цикла и завершить программу.
Integer.valueOf - метод преобразует String в int
 */

public class Dendy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Игры.");
            System.out.println("1. Танчики");
            System.out.println("2. Супер Марио");
            System.out.println("3. Выйти");
            System.out.print("Введите пункт меню, чтобы начать игру: ");
            int select = Integer.valueOf(input.nextLine());
            if (select == 3) {
                System.out.println("Игра завершена.");
                run = false;
            } else if (select == 1) {
                System.out.println("Танчики загружаются ... ");
            } else if (select == 2) {
                System.out.println("Супер Марио загружается ... ");
            } else {
                System.out.println("Такой игры нет.");
            }
            System.out.println();
        }
    }
}
