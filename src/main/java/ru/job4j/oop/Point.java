package ru.job4j.oop;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

/**
 * 2.1. Рефакторинг - Расстояние между точками
 *
 * Создаем Класс Point в котором будем вычислять расстояние между точками в системе координат x,y
 * Точка - объект; Класс описывает его свойства;
 * Создаем поля объекта (Состояние в объекте хранятся в полях), описывающие свойства объета;
 * Для инициализации начального состояния создадим конструктор Point, который принимает два параметра;
 * Метод distance возвращает расстояние между точками;
 *
 */

public class Point {

    private int x;
    private int y;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point that) {
        return sqrt(pow((this.x - that.x), 2) + pow((this.y - that.y), 2));
    }
}
