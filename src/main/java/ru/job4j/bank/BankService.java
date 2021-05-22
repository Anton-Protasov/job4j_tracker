package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * 3. Банковские переводы [#10038]
 * Главный сервис.
 * 2. Удалять пользователя из системы.
 *

 */

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * 1. Регистрировать пользователя.
     * + проверка, что такого пользователя еще нет в системе. Если он есть, то нового добавлять не надо.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
        }

    /**
     * 2. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
     * Первоначально пользователя нужно найти по паспорту. Для этого нужно использовать метод findByPassport.
     * После этого мы получим список всех счетов пользователя и добавим новый счет к ним.
     * В этом методе должна быть проверка, что такого счета у пользователя еще нет.
     */
    public void addAccount(String passport, Account account) {
        User user = this.findByPassport(passport);
        if(user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
            }
        }

    public User findByPassport(String passport) {
        User user = null;
        for (User index : users.keySet()) {
            if (index.getPassport().equals(passport)) {
                user = index;
                break;
            }
        }
        return user;
    }

    /**
     * Этот метод ищет счет пользователя по реквизитам.
     * Сначала нужно найти пользователя.
     * Потом получить список счетов этого пользователя и в нем найти нужный счет.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = this.findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            for (Account index: userAccounts) {
                if (index.getRequisite().equals(requisite)) {
                    account = index;
                    break;
                }
            }
        }
        return account;
    }

    /**
     *  3. Переводить деньги с одного банковского счета на другой счет.
     *  Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     *  то метод должен вернуть false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = this.findByRequisite(srcPassport, srcRequisite);
        Account destAccount = this.findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}