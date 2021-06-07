package ru.job4j.io;

import java.util.Scanner;

/*
2. Scanner и чтение числа из консоли. [#395208]
На столе лежат 11 спичек. Два игрока по очереди берут от 1 до 3 спичек.
Выигрывает тот, кто забрал последние спички
Игра заканчивается, когда игрок забрал последние спички.
В цикле нужно проверять количество спичек.
Сделайте ввод данных от пользователя. Сначала первый игрок вводит число от 1 до 3,
потом второй и так далее.
Когда игрок ввел цифру, нужно показать сколько спичек осталось на столе.
 */

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());

            // Валидация:
            while (matches < 1 || matches > 3 || matches > count) {
                System.out.println("не корректное значение. "
                        + "Вы можете взять только от 1 до 3 спичек, "
                        + "и не более оставшихся на столе попробуйте снова");
                matches = Integer.parseInt(input.nextLine());
            }

            turn = !turn;
            count = count - matches;
            System.out.println("На столе осталось " + count + " спичек");
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
