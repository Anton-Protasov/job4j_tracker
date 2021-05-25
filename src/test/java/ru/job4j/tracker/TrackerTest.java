package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.collection.Task;

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
        NaturalOrderItems no = new NaturalOrderItems();
        List<Item> items = new ArrayList<>();
        items.add(new Item(1,"Anton"));
        items.add(new Item(2,"Boris"));
        items.add(new Item(3,"Vova"));
        items.add(new Item(4,"Gena"));
        items.add(new Item(5,"Dima"));

        Collections.sort(items, no);

        List<Item> expected = new ArrayList<>(
                Arrays.asList(
                        new Item(1,"Anton"),
                        new Item(2,"Boris"),
                        new Item(3,"Vova"),
                        new Item(4,"Gena"),
                        new Item(5,"Dima")));

        assertThat(items, is(expected));
    }

    @Test
    public void whenSortItemsByReverseOrder() {
        ReverseOrderItems ro = new ReverseOrderItems();
        List<Item> items = new ArrayList<>();
        items.add(new Item(1,"Anton"));
        items.add(new Item(2,"Boris"));
        items.add(new Item(3,"Vova"));
        items.add(new Item(4,"Gena"));
        items.add(new Item(5,"Dima"));

        Collections.sort(items, ro);

        List<Item> expected = new ArrayList<>(
                Arrays.asList(
                        new Item(5,"Dima"),
                        new Item(4,"Gena"),
                        new Item(3,"Vova"),
                        new Item(2,"Boris"),
                        new Item(1,"Anton")));

        assertThat(items, is(expected));
    }

}