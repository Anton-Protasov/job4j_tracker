package ru.job4j.lambda;
import java.util.Arrays;
import java.util.Comparator;

/*
2.2. Лямбда блок [#249208]
 */

public class LambdaUsage {

    public static void main(String[] args) {
        String[] str = {"image 5000", "image -3340", "image 229"};

        /*
        Строки сравниваются по убыванию длины.
        с выводом отладочной информации на консоль.
         */
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left.length() + " : "
                    + right.length());
            return right.length() - left.length();
        };

        Arrays.sort(str, cmpDescSize);
        for (String i: str) {
            System.out.println(i);
        }
    }
}
