package ru.job4j.oop;

/*
3.1. Приведение типов. Повышение типа и понижение типа. [#395212]
приведение объекта Freshman к Student, а потом к Object
 */

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student student = freshman;
        Object object = freshman;
    }
}
