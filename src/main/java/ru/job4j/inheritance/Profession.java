package ru.job4j.inheritance;

import javax.print.Doc;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private short birthday;

    Profession(String name, String surname, String education, short birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    Profession() {
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getEducation(){
        return education;
    }

    public short getBirthday(){
        return birthday;
    }
}

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

    Engineer(){
    }

    public void output() {
    }
}

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

    Doctor(){
    }

    public void output() {
    }
}

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

class Builder extends Engineer {
    private String constructionType;

    Builder(String constructionType, short experiance, int price, String location,
            String name, String surname, String education, short birthday) {
        super(experiance, price, location, name, surname, education, birthday);
        this.constructionType = constructionType;
    }

    Builder(){
    }

    public void output() {
    }
}

class Surgeon extends Doctor {
    private String bodyParts;

    Surgeon(String bodyParts, char gender, short hospitalNumber, int price, String rank,
            String name, String surname, String education, short birthday) {
        super (gender, hospitalNumber, price, rank, name, surname, education, birthday);
        this.bodyParts = bodyParts;
    }

    Surgeon(){
    }

    public void output() {
    }
}

class Dantist extends Doctor {
    private String teethType;
    private short teeths;

    Dantist(String teethType, short teeths, char gender, short hospitalNumber, int price, String rank,
            String name, String surname, String education, short birthday) {
        super (gender, hospitalNumber, price, rank, name, surname, education, birthday);
        this.teethType = teethType;
        this.teeths = teeths;
    }

    Dantist(){
    }

    public void output() {
    }
}






