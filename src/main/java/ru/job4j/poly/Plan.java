package ru.job4j.poly;

public class Plan implements Vehicle {
    private int destination;

    Plan(int destination) {
        this.destination = destination;
    }

    @Override
    public int fare(int destination) {
        int money = -1;
        if (300 <= destination && destination <= 1000) {
            money = 3000;
        } else if (1000 > destination && destination <= 3000) {
            money = 5000;
        } else if (destination > 3000) {
            money = 10000;
        }
        return money;
    }

    @Override
    public void move() {
        int rsl = this.fare(destination);
        if (rsl == -1) {
            System.out.println("Это слишеом маленькое расстояние для самолета."
                    + "Выберите другой вид странспорта");
        } else {
            System.out.println("Стоимость проезда на самолете обойдется в: " + rsl + " рублей");
        }
    }
}
