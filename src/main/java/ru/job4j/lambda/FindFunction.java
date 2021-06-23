package ru.job4j.lambda;

/*
5. Подсчет функции в диапазоне. [#24251]
 */

import java.util.function.Function;
import java.util.List;
import java.util.ArrayList;

public class FindFunction {

    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        double x = start;
        while (x < end) {
            list.add(func.apply(x));
            x++;
        }
        return list;
    }
}