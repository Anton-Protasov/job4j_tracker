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

/* Вариант 1 - возвращает разницу между суммами юникодов всех символов первой строки и всех символов второй строки
(как работает стандартый метод String.compareTo)

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        for (int i = 0; i < left.length(); i++) {
            rsl += left.codePointAt(i);
        }
        for (int i = 0; i < right.length(); i++) {
            rsl -= right.codePointAt(i);
        }
        return rsl;
    }
}
 */

/* Вариант 2 - работает как требует условие задачи, но проблема если разница только в последних символах,
которые отличают строки друг от друга. Программа не способна их воспринять


public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int minLength = (left.length() < right.length()) ? left.length() : right.length();
        for (int i = 0; i < minLength; i++) {
            if (left.codePointAt(i) < right.codePointAt(i)) {
                rsl = -1;
                break;
            } else if (left.codePointAt(i) > right.codePointAt(i)) {
                rsl = 1;
                break;
            }
        }
        return rsl;
    }
}
 */

/* Вариант 3
Не увидел смысла в переводе строки в коллекцию символов.
Для решения пролемы, которая возникает во втором варианте,
при создании коллекции пробовал (через конструктор) задать длину коллекции вручную, которая была бы равна
длине самой длиной строки. Но при присвоении коллекции какого либо значения - длина автоматически меняетя
в соответствие с количеством присвоеных символов.
Развивать дальше данный вариант не стал - не увидел смысла

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {

        int rsl = 0;

        ArrayList<Character> charsLeft = new ArrayList<>();
        for (char c : left.toCharArray()) {
            charsLeft.add(c);
        }

        ArrayList<Character> charsRight = new ArrayList<>();
        for (char c : right.toCharArray()) {
            charsRight.add(c);
        }

        int minLength = (charsLeft.size() < charsRight.size()) ? charsLeft.size() : charsRight.size();

        for (int i = 0; i < minLength; i++) {


            rsl = charsLeft.get(i);
            }
        return rsl;
        }
    }
*/

/**
 * Вариант 4
 * Полностью рабочий вариант, но костыльный.
 * 2 несвязанных между собой условия... кажется можно как-то проще, но как...
 * минус данного варианта - изменение начальных слов.
 * При использовании коллекции мы бы сделали бы то же самое, но на слова не повлияло бы.
 * В таком же случае можно так же создать 2 дополнитеьные строки и присоить им значения first и second соответственно.
 * И видоизменять уже новые строки.
 *
 */
public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int maxLength = (left.length() > right.length()) ? left.length() : right.length();

        if(left.length() < maxLength) {
            while (left.length() != maxLength) {
                left += "0";
            }
        }

        if(right.length() < maxLength) {
            while (right.length() != maxLength) {
                right += "0";
            }
        }

        for (int i = 0; i < maxLength; i++) {
            if (left.codePointAt(i) < right.codePointAt(i)) {
                rsl = -1;
                break;
            } else if (left.codePointAt(i) > right.codePointAt(i)) {
                rsl = 1;
                break;
            }
        }
        return rsl;
    }
}

