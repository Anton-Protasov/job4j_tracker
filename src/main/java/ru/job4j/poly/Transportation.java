package ru.job4j.poly;

import java.util.Scanner;

public class Transportation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите расстояние кужа ехать: ");
        int destination = Integer.parseInt(scanner.nextLine());

        Vehicle train = new Train(destination);
        Vehicle plan = new Plan(destination);
        Vehicle bus = new Bus(destination);

        Vehicle[] vehicles = new Vehicle[]{train, plan, bus};
        for (Vehicle i : vehicles);
        i.move();
    }
}
