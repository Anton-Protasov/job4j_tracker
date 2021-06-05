package ru.job4j.bank;

/*
 * 3. Банковские переводы [#10038]
 */

import java.util.Objects;

/**
 * Class is a model of a client`s bank account
 * @author Anton Protasov
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     * @param requisite - the ID of an client`s account
     * @param balance - the current quantity of money on an account
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * the method allows to get a requisite of an account
     * @return of a account`s requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * the method allows to set a requisite of an account
     * @param requisite - a requisite should be indicated as input data of the method
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * the method allows to get the current balance of an account
     * @return of the current balance on the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * the method allows to set the current balance of an account
     * @param balance - a balance should be indicated as input data of the method
     */
    public void setBalance(double balance) {
        this.balance = balance;
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
