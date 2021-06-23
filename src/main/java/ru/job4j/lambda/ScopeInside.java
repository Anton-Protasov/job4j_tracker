package ru.job4j.lambda;

/*
4. Зона видимости в лямбда-выражениях и исключения [#70609]
 */

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 10, 0};
        int total = add(
                () -> {
                    int sum = 0;
                    for (int i = 0; i < number.length; i++) {
                        int num = number[i];
                        sum += num;
                    }
                    return sum;
                }
        );
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}