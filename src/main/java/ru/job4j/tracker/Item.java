package ru.job4j.tracker;

/*
 * 5. Tracker - хранилище [#395287]
 * Класс Item описывает модель заявления.
 * Поле id - это уникальный номер заявления.
 * Поле name содержит название заявления.
 * 9. toString [#395286]
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Item {
    private int id;
    private String name;
    private LocalDateTime created;

    public Item() {
    }

    public Item(int id){
        this.id = id;
    }

    public Item(String name){
        this.name = name;
    }

    public Item(LocalDateTime created){
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateAndTime() {
        return created;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                Objects.equals(name, item.name) &&
                Objects.equals(created, item.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
