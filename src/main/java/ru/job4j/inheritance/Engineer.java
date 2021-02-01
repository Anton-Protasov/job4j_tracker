package ru.job4j.inheritance;

class Engineer extends Profession {
    private short experiance;
    private int price;
    private String location;

    Engineer(short experiance, int price, String location,
             String name, String surname, String education, short birthday) {
        super(name, surname, education, birthday);
        this.experiance = experiance;
        this.price = price;
        this.location = location;
    }

    Engineer() {
    }

    public void output() {
    }
}
