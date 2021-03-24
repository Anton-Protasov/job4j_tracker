package ru.job4j.ex;

/**
 * Факториал через рекурсию
 */

public class FactRec {
    public static int calc(int n) {
        int rsl = 1;
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return calc(n - 1) * n;
        }
    }
        public static void main (String[] args) {
            int rsl = calc(4);
            System.out.println(rsl);
        }
    }