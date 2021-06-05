package ru.job4j.bank;

/*
 * 3. Банковские переводы [#10038]
 * Главный сервис.
 */

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Class is a model of a client`s bank account
 * @author Anton Protasov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных о пользователях банка осуществляется в коллекции типа HashMap
     * В качестве ключа задается объект User, в качестве значения используется список List
     * в которм хранится информация обо всех счетах, открытых у пользователя в банке
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в систему хранения данных, при этом,
     * пользватель должен пройти валидацию, определенную методом putIfAbsent
     * @param user - объект типа User, который собирается зарегистрироваться
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
        }

    /**
     * Метод позволяет добавить пользователю банковский счет. При этом
     * У пользователя может быть несколько счетов.
     * Перед добавлением счета пользователь должен быть зарегистрирован в системе.
     * @param passport - паспорт пользователя, которому необходимо добавить счет.
     *                 По данному параметру происходит поиск пользователя в системе банка.
     * @param account - банковский счет, который добавляется пользователю, при условии, что
     *                пользователь существует в системе и у него еще нет данного счета
     */
    public void addAccount(String passport, Account account) {
        User user = this.findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
            }
        }

    /**
     * Метод ищет пользоватедя по параметру passport
     * @param passport
     * @return - в случае если пользователь найдет, метод возвращает индекс
     * ключа в базе данных пользоватедя. Если пользователя с таким паспортом не существует -
     * метод возвращает null
     */
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
     * Метод ищет счет пользователя по параметрам passport и requisite
     * @param passport
     * @param requisite
     * @return - в случае если пользователь найден и у пользователя уже существует указанный
     * в параметре requisite счет, то метод возвращает индекс данного счета
     * в списке счетов данного пользователя
     * Если пользователя с таким паспортом не существует или у него не найден счет, указанный
     * в параметре requisite, то метод возвращает null
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
     * Метод реализует перевод с одного банковского счета на другой,
     * испольуя в качестве входных параметов следующие:
     * @param srcPassport - Паспорт пользователя с чьего счета необходимо перевести
     * @param srcRequisite - Номер счета пользователя с которого необходимо перевести
     * @param destPassport - Паспорт пользователя на чей счет необходимо зачислить
     * @param destRequisite - Номер счета пользователя на который необходимо зачислить
     * @param amount - сумма перевода
     * @return - метод определяет существуют ли указанные пользователи
     * и есть ли у них указанные счета. В случае, если данные пользователи
     * с данными счетами существуют, то метод выполняет перечисление суммы amount
     * и возвращает true. Иначе перечисление не выполняется, возвращается false.
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