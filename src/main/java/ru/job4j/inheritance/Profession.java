package ru.job4j.inheritance;

import javax.print.Doc;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private short birthday;

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

    public void output() {
    }
}

class Doctor extends Profession {
    private char gender;
    private short hospitalNumber;
    private int price;
    private String rank;

    public void output() {
    }
}

class Programmer extends Engineer {
    private String language;

    public void output() {
    }
}

class Builder extends Engineer {
    private String constructionType;

    public void output() {
    }
}

class Surgeon extends Doctor {
    private String bodyParts;

    public void output() {
    }
}

class Dantist extends Doctor {
    private String teethType;
    private short teeths;

    public void output() {
    }
}






