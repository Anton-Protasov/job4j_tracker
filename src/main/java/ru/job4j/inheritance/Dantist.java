package ru.job4j.inheritance;

class Dantist extends Doctor {
    private String teethType;
    private short teeths;

    Dantist(String teethType, short teeths, char gender, short hospitalNumber, int price, String rank,
            String name, String surname, String education, short birthday) {
        super(gender, hospitalNumber, price, rank, name, surname, education, birthday);
        this.teethType = teethType;
        this.teeths = teeths;
    }

    Dantist() {
    }

    public void output() {
    }
}
