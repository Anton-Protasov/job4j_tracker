package ru.job4j.poly;

import java.util.Scanner;

public class Bus implements Transport {


    @Override
    public void drive() {
        System.out.println("Куда едем?");
        Scanner input = new Scanner(System.in);
        String destination = input.nextLine();

    }

    @Override
    public void passengers (int pas) {
        System.out.println("Сколько пассажиров едет?");
        Scanner input = new Scanner(System.in);
        pas = Integer.valueOf(input.nextLine());

    }

    @Override
    public int cost(int petrol) {
        System.out.println("Сколько литров топлива заправить?");
        Scanner inputPetrol = new Scanner(System.in);
        petrol = Integer.valueOf(inputPetrol.nextLine());
        System.out.println("Сколько стоит один литр?");
        Scanner inputMoney = new Scanner(System.in);
        int money = Integer.valueOf(inputMoney.nextLine());
        return petrol * money;
    }
}
