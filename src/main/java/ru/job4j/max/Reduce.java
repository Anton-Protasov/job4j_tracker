package ru.job4j.max;

/**
 * 5.1. Зона видимости переменных [#395266]
 */

public class Reduce {
    private int[] array;

    public void to(int[] arrayMethod) {
        array = arrayMethod;
    }

    public void print() {
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }
}
