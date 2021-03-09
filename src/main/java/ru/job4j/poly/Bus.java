package ru.job4j.poly;

public class Bus implements Vehicle {
    private int destination;

    Bus(int destination) {
        this.destination = destination;
    }

    @Override
    public int fare(int destination) {
        int money = -1;
        if (100 >= destination) {
            money = 300;
        }
        else if (100 < destination && destination < 500) {
            money = 400;
        }
        else if (500 <= destination && destination <= 2000) {
            money = 3000;
        }
        return money;
    }

    @Override
    public void move() {
        int rsl = this.fare(destination);
        if (rsl == -1) {
            System.out.println("На такие расстояния автобусы не ездят." +
                    "Выберите другой вид странспорта");
        } else {
            System.out.println("Стоимость проезда на автобусе обойдется в: " + rsl + " рублей");
        }
    }
}