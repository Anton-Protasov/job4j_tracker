package ru.job4j.lambda;

/*
4. Зона видимости в лямбда-выражениях и исключения [#70609]
 */

/*
import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            int sum = add(
                    () -> {
                        int sumOfArray = total + num;
                        return sumOfArray;
                    }
            );
        }

    }

    private static Integer add(Supplier<Integer> calc) {
        System.out.println(sum);
        return calc.get();
    }
}
 */