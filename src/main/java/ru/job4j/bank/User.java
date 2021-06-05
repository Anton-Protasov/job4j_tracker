package ru.job4j.bank;

/*
 * 3. Банковские переводы [#10038]
 */

import java.util.Objects;

/**
 * Class is a model of a bank`s client
 * @author Anton Protasov
 * @version 1.0
 */
public class User {
    private String passport;
    private String username;

    /**
     * @param passport - the ID of an bank`s client
     * @param username - the username of an bank`s client
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * the method allows to get a client`s passport
     * @return of a client`s passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * the method allows to set a client`s passport
     * @param passport - a passport should be indicated as input data of the method
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * the method allows to get a client`s username
     * @return of a client`s username
     */
    public String getUsername() {
        return username;
    }

    /**
     * the method allows to set a client`s username
     * @param username - an username should be indicated as input data of the method
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * equals and hashCode are standard overridden methods
     * in order to be allow to use an object of this class
     * in operations with a comparison.
     * These methods were got by using a feature that integrated in IDEA
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}