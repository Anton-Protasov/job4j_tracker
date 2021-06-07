package ru.job4j.collection;

/*
 * 3. Модели данных и HashSet. [#395201]
 */

import java.util.Objects;

/**
 * Class is a model of a bank`s client
 * @author Anton Protasov
 * @version 1.0
 */
public class Account {
    private String passport;
    private String username;
    private String deposit;

    /**
     *
     * @param passport - number of the client`s ID
     * @param username - name of the client
     * @param deposit - bank`s account. A client can has not along an account
     *                also can has several accounts.
     */
    public Account(String passport, String username, String deposit) {
        this.passport = passport;
        this.username = username;
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(passport, account.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    /**
     * toString is a standard overridden method
     * in order to be allow to print all fields of object this class
     * without called them
     * This method was got by using a feature that integrated in IDEA
     */
    @Override
    public String toString() {
        return "Account{"
                + "passport='" + passport + '\''
                + ", username='" + username + '\''
                + ", deposit='" + deposit + '\''
                + '}';
    }
}