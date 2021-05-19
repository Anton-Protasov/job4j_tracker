package ru.job4j.collection;

import java.util.HashMap;

/**
 * 0. Map, HashMap [#212652]
 */

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("89267016232@mail.ru", "Protasov Anton");
        for(String key: map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
