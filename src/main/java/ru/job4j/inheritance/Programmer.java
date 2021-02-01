package ru.job4j.inheritance;

class Programmer extends Engineer {
    private String language;

    Programmer(String language, short experiance, int price, String location,
               String name, String surname, String education, short birthday) {
        super(experiance, price, location, name, surname, education, birthday);
        this.language = language;
    }

    public void output() {
    }
}
