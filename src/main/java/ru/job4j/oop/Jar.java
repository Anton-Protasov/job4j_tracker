package ru.job4j.oop;

/*
1.7. Состояние объекта [#395264]
У нас есть два сосуда с водой. Нужно перелить из одного сосуда в другой всю воду.
1 - поле value - В поле будет содержаться количество воды
2 - добавим конструктор Jar(int size) для инициализации начального состояния сосуда
3 - добавим в него метод public void pour(Jar another),
который будет принимать объект типа Jar
4 - first.pour(second):
У объекта first вызываем метод pour. В нем есть поле this.value
- this - указывает на то что нужно взять значение этой переменной у
объекта для которого мы вызываем метод.
то есть если мы вызываем метод pour у объекта first, то this.value будет 10.
если мы вызовем у объекта second метод pour, то для него будет значение this.value  равно 5.
Дальше в методе pour передается переменная another.
То есть в нашем методе есть два объекта и два значения value.
Первый это у кого мы вызываем метод pour и второй этот тот объект, который мы передаем в метод pour.
 */

public class Jar {

    private int value;

    public Jar(int size) {
        this.value = size;
    }

    public void pour(Jar another) {
        this.value = this.value + another.value;
        another.value = 0;
    }

    public static void main(String[] args) {
        Jar first = new Jar(10);
        Jar second = new Jar(5);
        System.out.println("first : " + first.value + ". second : " + second.value);
        first.pour(second);
        System.out.println("first : " + first.value + ". second : " + second.value);

    }
}
