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

        String[] str = {"image 5000", "image -3340", "image 229"};

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
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);

        /*
        Строки сравниваются по убыванию длины.
         */
        Comparator<String> cmpDescSize = (left, right) ->
                Integer.compare(right.length(), left.length());

        // Arrays.sort(atts, comparator);
        Arrays.sort(str, cmpText);
        for (String i: str) {
            System.out.println(i);
        }

        Arrays.sort(str, cmpDescSize);
        for (String i: str) {
            System.out.println(i);
        }
    }
}