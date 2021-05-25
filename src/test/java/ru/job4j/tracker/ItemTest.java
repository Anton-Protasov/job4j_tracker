package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ItemTest {

    @Test
    public void natOrdTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1,"Anton"));
        items.add(new Item(2,"Boris"));
        items.add(new Item(3,"Vova"));
        items.add(new Item(4,"Gena"));
        items.add(new Item(5,"Dima"));

        List<Item> expected = new ArrayList<>(
                Arrays.asList(
                        new Item(1,"Anton"),
                        new Item(2,"Boris"),
                        new Item(3,"Vova"),
                        new Item(4,"Gena"),
                        new Item(5,"Dima")));

        Item item = new Item();
        assertThat(item.natOrd(items), expected);
    }
}