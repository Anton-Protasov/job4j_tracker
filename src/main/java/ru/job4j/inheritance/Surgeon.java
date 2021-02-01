package ru.job4j.inheritance;

class Surgeon extends Doctor {
    private String bodyParts;

    Surgeon(String bodyParts, char gender, short hospitalNumber, int price, String rank,
            String name, String surname, String education, short birthday) {
        super(gender, hospitalNumber, price, rank, name, surname, education, birthday);
        this.bodyParts = bodyParts;
    }

    Surgeon() {
    }

    public void output() {
    }
}
