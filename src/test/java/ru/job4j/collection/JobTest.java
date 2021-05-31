package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;

import java.util.*;

public class JobTest {
    @Test
    public void whenNameInNOrder() {
        List<Job> namesNOrd = new ArrayList<>(
                Arrays.asList(
                        new Job("Anton", 1),
                        new Job("Boris", 2),
                        new Job("Valera", 3),
                        new Job("Galina", 4),
                        new Job("Dima", 5)
                        ));
        Collections.sort(namesNOrd, new JobSortByName());
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Anton", 1),
                        new Job("Boris", 2),
                        new Job("Dima", 5),
                        new Job("Galina", 4),
                        new Job("Valera", 3)
                ));
        assertThat(namesNOrd, is(expected));
    }

    @Test
    public void whenNameInROrder() {
        List<Job> namesROrd = new ArrayList<>(
                Arrays.asList(
                        new Job("Anton", 1),
                        new Job("Boris", 2),
                        new Job("Valera", 3),
                        new Job("Galina", 4),
                        new Job("Dima", 5)
                ));
        Collections.sort(namesROrd, new JobSortByNameRevers());
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Valera", 3),
                        new Job("Galina", 4),
                        new Job("Dima", 5),
                        new Job("Boris", 2),
                        new Job("Anton", 1)
                ));
        assertThat(namesROrd, is(expected));
    }

    @Test
    public void whenPriorityInNOrder() {
        List<Job> priorNOrd = new ArrayList<>(
                Arrays.asList(
                        new Job("Anton", 1),
                        new Job("Boris", 2),
                        new Job("Valera", 3),
                        new Job("Galina", 4),
                        new Job("Dima", 5)
                ));
        Collections.sort(priorNOrd, new JobSortByPriority());
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Anton", 1),
                        new Job("Boris", 2),
                        new Job("Valera", 3),
                        new Job("Galina", 4),
                        new Job("Dima", 5)
                ));
        assertThat(priorNOrd, is(expected));
    }

    @Test
    public void whenPriorityInROrder() {
        List<Job> priorROrd = new ArrayList<>(
                Arrays.asList(
                        new Job("Anton", 1),
                        new Job("Boris", 2),
                        new Job("Valera", 3),
                        new Job("Galina", 4),
                        new Job("Dima", 5)
                ));
        Collections.sort(priorROrd, new JobSortByPriorityRevers());
        List<Job> expected = new ArrayList<>(
                Arrays.asList(
                        new Job("Dima", 5),
                        new Job("Galina", 4),
                        new Job("Valera", 3),
                        new Job("Boris", 2),
                        new Job("Anton", 1)
                ));
        assertThat(priorROrd, is(expected));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobSortByName().thenComparing(new JobSortByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByProrityWithEqualNames() {
        Comparator<Job> cmpNamePriority = new JobSortByName().thenComparing(new JobSortByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}
