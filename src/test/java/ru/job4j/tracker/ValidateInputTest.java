package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест whenInvalidInput проверяет ситуацию, когда пользователь ввел сначала неверные данные, а потом верные.
 */

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1", "10500", "abvgd", "7"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Any question - does not matter");
        assertThat(selected, is(1));
    }

    /**
     * Тест whenManyTimesInvalidInput проверяет многократный правильный ввод.
     */

    @Test
    public void whenManyTimesInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Any question - does not matter");
        assertThat(selected, is(1));
    }

    /**
     * Тест whenInvalidInputIsNegative проверяет ввод отрицательного числа.
     */

    @Test
    public void whenInvalidInputIsNegative() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1", "-2", "3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Any question - does not matter");
        assertThat(selected, is(-1));
    }
}