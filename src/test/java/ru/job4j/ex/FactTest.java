package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCalc() {
        Fact.calc(-6);
    }
}