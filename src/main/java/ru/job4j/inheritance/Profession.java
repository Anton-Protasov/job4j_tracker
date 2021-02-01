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






