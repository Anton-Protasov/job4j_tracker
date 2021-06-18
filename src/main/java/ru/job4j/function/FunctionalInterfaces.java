package ru.job4j.function;

/*
 * 1.2. Функциональный интерфейс [#247497]
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);
        String[] value = {"one", "two", "three", "four", "five", "six", "seven"};
        for (int i = 0; i < value.length; i++) {
            biCon.accept(i + 1, value[i]);
        }

        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 || s.length() == 4;
        for (Integer i : map.keySet()) {
            String s = map.get(i);
            if (biPred.test(i, s)) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();

        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = (s) -> s.toUpperCase();
        for (String s : strings) {
            con.accept(func.apply(s));
        }
    }
}