package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input input) {
        this.out = out;
        this.in = input;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

/**
 *    Option 1.
 *    We will use Unchecked Exceptions (NumberFormatException) as Handle type
 */

public int askInt(String question){
    boolean invalid = true;
    int value = -1;
    do {
        try {
            value = in.askInt(question);
            invalid = false;
        } catch (NumberFormatException nfe) {
            out.println("You entered invalidate data. Please enter validate data.");
        }
    } while (invalid);
    return value;
    }
}
