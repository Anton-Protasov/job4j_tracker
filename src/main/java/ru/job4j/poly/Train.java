package ru.job4j.poly;

public class Train implements Vehicle {
    private int destination;

    Train(int destination) {
        this.destination = destination;
    }

    @Override
    public int fare(int destination) {
        int money = -1;
        if (100 <= destination && destination < 500) {
            money = 500;
        } else if (500 <= destination && destination <= 1000) {
            money = 2000;
        } else if (1000 < destination && destination <= 5000) {
            money = 4000;
        }
        return money;
    }

    @Override
    public void move() {
        int rsl = this.fare(destination);
        if (rsl == -1) {
            System.out.println("На такие расстояния поезда не ездят."
                    + "Выберите другой вид странспорта");
        } else {
            System.out.println("Стоимость проезда на поезде обойдется в: " + rsl + " рублей");
        }
    }
}