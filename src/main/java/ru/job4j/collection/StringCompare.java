package ru.job4j.collection;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

/**
 * 3. Компаратор для строк [#35008]
 * Существует готовый метод String.compareTo.
 * В этом задании нужно создать подобный метод самому.
 * Компаратор для сравнения двух массивов символов.
 */

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            int compareRslChar = Character.compare(left.charAt(i), right.charAt(i));
            if (compareRslChar != 0) {
                rsl = compareRslChar;
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(left.length(), right.length());
        }
        return rsl;
    }
}