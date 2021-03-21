package ru.job4j.ex;

/**
 * метод поиска индекса элемента в строковом массиве
 */

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
        }
            }
        return rsl;
        if (rsl == -1) {
            throw new ElementNotFoundException ("Element has not found");
        }
    }

    public static void main(String[] args) {
        String[] value = {"a", "b", "our", "c"};
        try {
            indexOf(value, "no");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}