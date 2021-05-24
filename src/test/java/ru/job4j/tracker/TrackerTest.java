package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenSortItemsByNaturalOrder() {
        Tracker tracker = new Tracker();

        /* Вариант 1

        List<Item> items = List.of(new Item("Anton"), new Item("Boris"),
                new Item("Vova"), new Item("Gena"), new Item("Dima"));
        NaturalOrderItems no = new NaturalOrderItems();
        Collections.sort(items, no);
        List<Item> expected = List.of(new Item("Anton"), new Item("Boris"),
                new Item("Vova"), new Item("Gena"), new Item("Dima"));
         */

        /* Вариант 2

        List<Item> items = new ArrayList<>();
        items.add(new Item("Anton"));
        items.add(new Item("Boris"));
        items.add(new Item("Vova"));
        items.add(new Item("Gena"));
        items.add(new Item("Dima"));

        NaturalOrderItems no = new NaturalOrderItems();
        Collections.sort(items, no);

        List<Item> expected = new ArrayList<>(
                Arrays.asList(
                        new Item("Anton"),
                        new Item("Boris"),
                        new Item("Vova"),
                        new Item("Gena"),
                        new Item("Dima")));
         */

        /* Вариант 3

        tracker.add(new Item("Anton"));
        tracker.add(new Item("Boris"));
        tracker.add(new Item("Vova"));
        tracker.add(new Item("Gena"));
        tracker.add(new Item("Dima"));


        NaturalOrderItems no = new NaturalOrderItems();
        Collections.sort(tracker.findAll(), no);

        List<Item> expected = new ArrayList<>(
                Arrays.asList(
                        new Item("Anton"),
                        new Item("Boris"),
                        new Item("Vova"),
                        new Item("Gena"),
                        new Item("Dima")));

        assertThat(tracker.findAll(), is(expected));
         */
    }
}