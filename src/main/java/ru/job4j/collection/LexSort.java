package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 4. Сортировка номера [#221284]
 */

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {

        int rsl = 0;

        /**
         * Убираем из левой стройки всю текстовую часть.
         * например: "10.0130.73 Task 1" --> "10.0130.73"
         */
        int newSizeLeft = 0;
        for(char i: left.toCharArray()) {
            if (i >= 48 && i <= 57 || i == 46) {
                newSizeLeft++;
            } else {
                break;
            }
        }
        String newLeft = left.substring(0, newSizeLeft);
        /**
         * Преобразуем полученную стороку в массив строк:
         * например: "10.0130.73" --> ["10" 0130" "73"]
         */
        String[] leftArray = newLeft.split("\\.");

        /**
         * Все тоже самое для правой строки
         */
        int newSizeRight = 0;
        for(char i: right.toCharArray()) {
            if (i >= 48 && i <= 57 || i == 46) {
                newSizeRight++;
            } else {
                break;
            }
        }
        String newRight = right.substring(0, newSizeRight);
        String[] rightArray = newRight.split("\\.");

        /**
         * Определяем min длину массива для последующего поэлементного сравнения
         * Далее извлекаем каждый элемент массива преобразуя его из String в Int и сравниваем
         * Результат сравнения передаем в rsl.
         * если длина одного массива больше длины другого, то массив с меньшим колличеством элементов при сравнении
         * будет меньше
         */
        int minLength = Math.min(leftArray.length, rightArray.length);
        for (int i = 0; i < minLength; i++) {
            int rslCompare = Integer.compare(Integer.parseInt(leftArray[i]), Integer.parseInt(rightArray[i]));
            if (rslCompare != 0) {
                rsl = rslCompare;
                break;
            } else {
                rsl = Integer.compare(leftArray.length, rightArray.length);
            }
        }
        return rsl;
    }
}

