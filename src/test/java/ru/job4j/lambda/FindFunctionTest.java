package ru.job4j.lambda;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.List;
import java.util.Arrays;

public class FindFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FindFunction function = new FindFunction();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunction() {
        FindFunction function = new FindFunction();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenIndicativeFunction() {
        FindFunction function = new FindFunction();
        List<Double> result = function.diapason(1, 4, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(2D, 4D, 8D);
        assertThat(result, is(expected));
    }
}