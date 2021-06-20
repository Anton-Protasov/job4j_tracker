package ru.job4j.function;
import java.util.function.Predicate;

/*
1.3. Встроенные функциональные интерфейсы. [#249209]
 */

public class StrategyUsage {

        public boolean check(Predicate<String> pred, String s) {
            return pred.test(s);
        }

    public static void main(String[] args) {
        StrategyUsage usage = new StrategyUsage();
        System.out.println(
                "Результат работы: " + usage.check(
                        str -> str.isEmpty(), ""
                )
        );
        System.out.println(
                "Результат работы: " + usage.check(
                        str -> str.startsWith("Fun"), "Functional interface"
                )
        );
        System.out.println(
                "Результат работы: " + usage.check(
                        str -> str.contains("rn"), "Surname Name"
                )
        );
    }
}