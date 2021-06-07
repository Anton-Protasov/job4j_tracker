package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

/**
 * 3. Модели данных и HashSet. [#395201]
 * В банковской системе, есть рассылка.
 * Клиент подписался на разные рассылки. Может быть такая ситуация,
 * что клиент должен получить сразу несколько писем.
 * Чтобы система не спамила клиента, там нужно оставить только уникальных клиентов для отправки.
 * То есть если клиент должен получить уведомление по разным подпискам,
 * мы будем упаковывать их в одно письмо.
 * Решение этой задачи сводиться к преобразованию List в Set.
 * HashSet устранит дубликаты клиентов банка самостоятельно.
 */

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        for (Account account: accounts) {
            rsl.add(account);
        }
        return rsl;
    }
}