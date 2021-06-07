package ru.job4j.oop;

/*
1.7. Состояние объекта [#395264]
Создать метод public void exchange(Battery another).
Этот метод должен списывать заряд из батареи у кого вызывали метод
exchange и добавить к объекту another.
 */

public class Battery {

    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(10);
        Battery second = new Battery(5);
        System.out.println("first : " + first.load + ". second : " + second.load);
        first.exchange(second);
        System.out.println("first : " + first.load + ". second : " + second.load);
    }
}
