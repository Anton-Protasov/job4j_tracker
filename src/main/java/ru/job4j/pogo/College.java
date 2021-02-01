package ru.job4j.pogo;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Антон");
        student.setSurname("Протасов");
        student.setMidlname("Юрьевич");
        student.setGroupNumber("E156TR");
        student.setDate(new Date());

        System.out.println(student.getSurname() + " " + student.getName() + " " + student.getMidlname());
        System.out.println("Группа " + student.getGroupNumber());
        System.out.println("Год поступления: " + student.getDate());
    }
}
