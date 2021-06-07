package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Animals cow = new Cow();
        Animals goose = new Goose();
        Animals dog = new Dog();
        Animals guineaPig = new GuineaPig();

        Animals[] animals = new Animals[]{cow, goose, dog, guineaPig};
        for (Animals a : animals) {
            a.sound();
        }
    }
}
