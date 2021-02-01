package ru.job4j.inheritance;

class Builder extends Engineer {
    private String constructionType;

    Builder(String constructionType, short experiance, int price, String location,
            String name, String surname, String education, short birthday) {
        super(experiance, price, location, name, surname, education, birthday);
        this.constructionType = constructionType;
    }

    Builder() {
    }

    public void output() {
    }
}
