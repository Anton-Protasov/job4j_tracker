package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. Конвертация двумерного массива в ArrayList [#395188]
 * Метод toList - принимает двухмерный массив array.
 * Необходимо пройти по всем элементам этого массива и добавить его в одномерный список list.
 */

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row: array) {
            for (int cell: row) {
                list.add(cell);
            }
        }
        return list;
    }
}
