package ru.job4j.inheritance;

class Doctor extends Profession {
    private char gender;
    private short hospitalNumber;
    private int price;
    private String rank;

    Doctor(char gender, short hospitalNumber, int price, String rank,
           String name, String surname, String education, short birthday) {
        super(name, surname, education, birthday);
        this.gender = gender;
        this.hospitalNumber = hospitalNumber;
        this.price = price;
        this.rank = rank;
    }

    Doctor() {
    }

    public void output() {
    }
}
