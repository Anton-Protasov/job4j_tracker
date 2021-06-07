package ru.job4j.oop;

import static java.lang.Math.sqrt;
import ru.job4j.oop.Point;

/**
 *  2.2. Рефакторинг - Площадь треугольника
 * 1 - определим, что треугольник существует (метод exist):
 * сумма его двух сторон должна быть больше третьей стороны
 * 2 - определим полупериметр треугольника (метод period) = (сумма сторон) /2
 * 3 - опрелеляем площадь треугольника (метод area), если, конечно, треугольник существует.
 * Иначе rsl = -1;
 * 4 - В тестах нам нужно создать три объекта Point, чтобы протестировать вычисление площади.
 * То есть мы работаем с объектами, а не с координатами.
 */
public class Triangle {

    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        return ((ab + ac) > bc) && ((ab + bc) > ac) && ((ac + bc) > ab);
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}
