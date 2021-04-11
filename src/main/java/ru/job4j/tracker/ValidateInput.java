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

/**
 *    Option 2.
 *    with additional check that is redundant

    private boolean isNumber(String value) {
        boolean rsl = true;
        char[] check = value.toCharArray();
        for (char num : check) {
            if (num < 48 || num > 57) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    @Override
    public int askInt(String question) {
        Input input = new ConsoleInput();
        boolean invalid = true;
        int value = -1;
        do {
            String rsl = input.askStr(question);
            if (!isNumber(rsl)) {
                System.out.println("Please enter validate data again.");
                continue;
            }
            value = Integer.parseInt(rsl);
            invalid = false;
        } while (invalid);
        return value;
    }
    }
 */
