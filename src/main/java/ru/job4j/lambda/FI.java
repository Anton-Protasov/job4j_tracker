package ru.job4j.lambda;
import java.util.Comparator;
import java.util.Arrays;

/*
2.1. Лямбда [#58165]
 */

public class FI {

    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 5000", 20),
                new Attachment("image -3340", 120),
                new Attachment("image 229", 23)
        };

        /*
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
         */

        Comparator<String> cmpSize = (left, right) -> left.length() - right.length();

        /*
        Строки сравниваются через метод compareTo.
         */
        Comparator<Attachment> cmpText = (left, right) -> left.getName().compareTo(right.getName());

        /*
        Строки сравниваются по убыванию длины.
         */
        Comparator<Attachment> cmpDescSize = (left, right) ->
                right.getName().length() - left.getName().length();

        // Arrays.sort(atts, comparator);
        Arrays.sort(atts, cmpText);
        for (Attachment i: atts) {
            System.out.println(i);
        }

        Arrays.sort(atts, cmpDescSize);
        for (Attachment i: atts) {
            System.out.println(i);
        }
    }
}