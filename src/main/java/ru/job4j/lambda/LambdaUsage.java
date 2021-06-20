package ru.job4j.lambda;
import java.util.Arrays;
import java.util.Comparator;

/*
2.2. Лямбда блок [#249208]
 */

public class LambdaUsage {

    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 5000", 20),
                new Attachment("image -3340", 120),
                new Attachment("image 229", 23)
        };

        /*
        Строки сравниваются по убыванию длины.
        с выводом отладочной информации на консоль.
         */
        Comparator<Attachment> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left.getName().length() + " : "
                    + right.getName().length());
            return right.getName().length() - left.getName().length();
        };

        Arrays.sort(atts, cmpDescSize);
        for (Attachment i: atts) {
            System.out.println(i);
        }
    }
}
