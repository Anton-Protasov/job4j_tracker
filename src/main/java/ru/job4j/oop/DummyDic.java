package ru.job4j.oop;

/*
1.4. Вызов метода с возвращаемым типом. [#395263]метода с аргументами. [#395261]
 */
public class DummyDic {

    public String engToRus(String eng) {
        return "Неизвестное слово." + eng;
    }

    public static void main(String[] args) {
        DummyDic example = new DummyDic();
        System.out.println(example.engToRus("example"));
    }
}
