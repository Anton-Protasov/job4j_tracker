package ru.job4j.pogo;
import java.util.Date;

/**
 * 2. Модель данных. [#395278]
 * Пример применения геттеров и сеттеров
 */

public class Student {
    private String name;
    private String surname;
    private String midlname;
    private String groupNumber;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMidlname() {
        return midlname;
    }

    public void setMidlname(String midlname) {
        this.midlname = midlname;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
