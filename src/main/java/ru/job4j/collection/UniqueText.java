package ru.job4j.collection;

import java.util.HashSet;

/**
 * 2. Идентичные тексты [#395200]
 * Метод isEquals будет сравнивать два текста.
 * Если они состоят из один и тех же слов, то мы считаем, что текст не уникальный.
 */

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for(String word: origin) {
            check.add(word);
        }
        for(String word: text) {
            if (!check.contains(word)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
